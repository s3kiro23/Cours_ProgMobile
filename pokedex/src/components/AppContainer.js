import {NavigationContainer} from "@react-navigation/native";
import {NativeBaseProvider} from "native-base";
import theme from "../theme";

const AppContainer = ({children}) => {
    return (
        <NavigationContainer>
            <NativeBaseProvider class={theme}>
                {children}
            </NativeBaseProvider>
        </NavigationContainer>
    );
};

export default AppContainer