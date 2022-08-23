import React, {useEffect, useState} from "react";
import axios from "axios";

const DataDisplay = () => {

    const [pokemon, setPokemon] = useState();
    const [pokemonName, setPokemonName] = useState();
    const [error, setError] = useState(false);
    const [isLoading, setIsLoading] = useState(false);

    const handleFetchPokemonName = (e) => {
        setPokemonName(e.target.value)
    }

    const handleFetchPokemon = () => {
        if (pokemonName !== "") {
            axios({
                method: "get",
                url: `https://pokeapi.co/api/v2/pokemon/${pokemonName}`,
            })
                .then((res) => {
                    setIsLoading(true);
                    setError(false);
                    setPokemon(res.data);
                })
                .catch(() => {
                    setError(true);
                    setPokemon();
                });
            setIsLoading(false);
        }
    }

    useEffect(() => {
        if ({pokemonName}.length >= 3) handleFetchPokemon();
    }, [pokemonName]);

    return (
        <>
            <h1>Data Display</h1>
            {isLoading && <p>Recherche en cours dans le pokedex...</p>}
            {error && <p>Ce pokémon ({pokemonName}) n'existe pas !</p>}
            <input
                type="text"
                value={pokemonName}
                onChange={handleFetchPokemonName}
                style={{background: "lightgray", padding: 5, alignSelf: "center"}}
            />
            <button style={{marginTop: 20, marginLeft: 10}} onClick={handleFetchPokemon}>Chercher Pokémon</button>
            {pokemon && (
                <div>
                    <h3>Voici mon pokémon : {pokemon.name}</h3>
                    <img src={pokemon.sprites.back_default} alt="img_pokemon"/>
                    <details>
                        <summary>Voici ses capacités :</summary>
                        <ul>
                            {pokemon.stats.map(({stat, base_stat, effort}) => (
                                <>
                                    <li>{stat.name}</li>
                                    <ul>
                                        <li>{base_stat}</li>
                                        <li>{effort}</li>
                                    </ul>
                                </>
                            ))}
                        </ul>
                    </details>
                    <details>
                        <summary>Voici ses habilités :</summary>
                        <ul>
                            {pokemon.abilities.map(({ability, slot}) => (
                                <>
                                    <li>{ability.name}</li>
                                    <ul>
                                        <li>Nombre de slot : {slot}</li>
                                    </ul>
                                </>
                            ))}
                        </ul>
                    </details>
                    <details>
                        <summary>Voici ses objets tenus :</summary>
                        <ul>
                            {pokemon.held_items.map(({item}) => (
                                <>
                                    <li>{item.name}</li>
                                </>
                            ))}
                        </ul>
                    </details>
                </div>
            )}
        </>
    )
};

export default DataDisplay