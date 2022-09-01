import * as React from 'react';
import {View, useWindowDimensions} from 'react-native';
import {TabView, SceneMap} from 'react-native-tab-view';
import {Box, Button, Center, Flex, Image, Input, Text} from "native-base";
import axios from "axios";

export default function TabViewExample() {

    const [pokemon, setPokemon] = React.useState(0);
    const [pokemonName, setPokemonName] = React.useState();
    const [error, setError] = React.useState(false);

    const handleFetchPokemon = () => {
        if (pokemonName !== "") {
            axios({
                method: "get",
                url: `https://pokeapi.co/api/v2/pokemon/${pokemonName}`,
            })
                .then((res) => {
                    console.log(res.data);
                    setError(false);
                    setPokemon(res.data);
                })
                .catch(() => {
                    setError(true);
                    setPokemon();
                });
        }
    }

    const FirstRoute = () => (
        <View style={{flex: 1}}>
            <Text><Text fontWeight={"bold"}>Nom : </Text>{pokemon.name}</Text>
            <Text><Text fontWeight={"bold"}>Taille :</Text> 0,{pokemon.height} m</Text>
            <Text><Text fontWeight={"bold"}>Poids :</Text> 0,{pokemon.weight} kg</Text>
            {/*{pokemon.stats.map(({stat, base_stat}) => (
                <>
                    <Text bold>{stat.name} :</Text>
                    <Text>{base_stat}</Text>
                </>
                ))
            };*/}
        </View>
    );

    const SecondRoute = () => (
        <View style={{flex: 1}}/>
    );

    const renderScene = SceneMap({
        first: FirstRoute,
        second: SecondRoute,
    });
    const layout = useWindowDimensions();

    const [index, setIndex] = React.useState(0);
    const [routes] = React.useState([
        {key: 'first', title: 'About'},
        {key: 'second', title: 'Base stats'},
    ]);

    return (
        <>
            <Center>
                <Text fontWeight={"bold"} fontSize={25} mt={25}>
                    Pokédex v0.2 alpha
                </Text>
            </Center>
            {error && <Text>Ce pokémon ({pokemonName}) n'existe pas !</Text>}
            <Input type="text"
                   placeholder={"Entrez le nom du pokémon"}
                   onChange={(e) => setPokemonName(e.nativeEvent.text)}
                   bg={"emerald.50"}
                   mt={25}
            />
            <Button mt={5} mb={5} colorScheme={"emerald"} onPress={handleFetchPokemon}>Rechercher!</Button>
            {/*{pokemon && (
                <Center><Image source={{uri: pokemon.sprites.front_default}} alt="img_pokemon" size={"2xl"}/></Center>
            )}*/}
            <TabView
                navigationState={{index, routes}}
                renderScene={renderScene}
                onIndexChange={setIndex}
                initialLayout={{width: layout.width}}
            />
        </>
    );
}