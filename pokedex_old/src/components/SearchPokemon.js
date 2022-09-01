/*
import {
    Text,
    View,
    Center,
    VStack,
    Button,
    useColorModeValue,
    Input,
    Image,
    Box,
    Flex
} from 'native-base';
import React, {useState, useEffect} from "react";
import axios from "axios";
import ToggleTheme from "../components/ToggleTheme";
import {Spacer} from "native-base/src/components/primitives/Flex";
import TabViewExample from "../components/Tabs";

const Main = () => {
    const [buttonColor, setButtonColor] = useState("emerald");
    const [pokemon, setPokemon] = useState();
    const [pokemonName, setPokemonName] = useState();
    const [error, setError] = useState(false);

    const onPressChangeButtonColor = () => {
        setButtonColor(buttonColor === "emerald" ? "danger" : "emerald")
    }

    const handleFetchPokemon = () => {
        if (pokemonName !== "") {
            axios({
                method: "get",
                url: `https://pokeapi.co/api/v2/pokemon/${pokemonName}`,
            })
                .then((res) => {
                    setError(false);
                    setPokemon(res.data);
                })
                .catch(() => {
                    setError(true);
                    setPokemon();
                });
        }
    }

    useEffect(() => {
        if ({pokemonName}.length >= 3) handleFetchPokemon();
    }, [pokemonName]);

    return (
        <View bg={useColorModeValue("blue.200", "amber.500")} p={3} w={"full"} h={"full"}>

            <VStack space={5} mt={25}>
                <Center>
                    <ToggleTheme/>
                    <Text fontWeight={"bold"} fontSize={25}>
                        Pokédex
                    </Text>
                </Center>
                {error && <Text>Ce pokémon ({pokemonName}) n'existe pas !</Text>}
                <Input type="text"
                       placeholder={"Entrez le nom du pokémon"}
                       onChange={(e) => setPokemonName(e.nativeEvent.text)}
                       bg={"emerald.50"}
                />
                <Button colorScheme={buttonColor} onPress={handleFetchPokemon}>Rechercher!</Button>

                {pokemon && (
                    <Center>
                        <Text mb={5}>Voici mon pokémon : <Text fontWeight={"bold"}>{pokemon.name}</Text></Text>
                        <Image source={{uri: pokemon.sprites.front_default}} alt="img_pokemon" size={"xl"}/>
                        {/!*<Flex direction={"row"}>
                            <VStack space={2}>
                                <Text underline italic>Voici ses capacités</Text>
                                {pokemon.stats.map(({stat, base_stat}) => (
                                    <Flex direction={"row"} key={stat.name}>
                                        <Text bold>{stat.name} : </Text>
                                        <Text>{base_stat}</Text>
                                    </Flex>
                                ))}
                            </VStack>
                            <Spacer/>
                            <VStack space={2}>
                                <Text underline italic>Voici ses habilités</Text>
                                {pokemon.abilities.map(({ability}) => (
                                    <Box key={ability.name}>
                                        <Text bold>{ability.name}</Text>
                                    </Box>
                                ))}
                            </VStack>
                        </Flex>*!/}

                        {/!*<AccordionDetails>
                            <AccordionSummary>
                                <Text>Voici ses habilités :</Text>
                            </AccordionSummary>
                            <UnorderedList>
                                {pokemon.abilities.map(({ability, slot}) => (
                                    <>
                                        <List>{ability.name}</List>
                                        <UnorderedList>
                                            <List>
                                                <Text>Nombre de slot : </Text>{slot}
                                            </List>
                                        </UnorderedList>
                                    </>
                                ))}
                            </UnorderedList>
                        </AccordionDetails>
                        <AccordionDetails>
                            <AccordionSummary>
                                <Text>Voici ses objets tenus :</Text>
                            </AccordionSummary>
                            <UnorderedList>
                                {pokemon.held_items.map(({item}) => (
                                    <>
                                        <List>{item.name}</List>
                                    </>
                                ))}
                            </UnorderedList>
                        </AccordionDetails>*!/}
                    </Center>
                )}
            </VStack>
            <TabViewExample/>
        </View>*/
