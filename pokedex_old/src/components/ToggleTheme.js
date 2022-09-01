import {HStack, Text, Switch, useColorMode, Box} from "native-base";

const ToggleTheme = () => {
    const {colorMode, toggleColorMode} = useColorMode();

    return (
        <Box justifyContent={"flex-end"}>
            <HStack>
                <Text>Dark</Text>
                <Switch isChecked={colorMode === "light"}
                        onToggle={toggleColorMode}></Switch>
                <Text>Light</Text>
            </HStack>
        </Box>
    );
};

export default ToggleTheme;