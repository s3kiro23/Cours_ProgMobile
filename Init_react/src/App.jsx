import React from "react";
import FirstApp from "./components/FirstApp";
import MainLayout from "./layouts/MainLayout.jsx";

const App = () => {
    const toto = "Hey, toi?!";
    const myfunction = () => {
        return "Ceci est un test";
    }

    return (
        <MainLayout title={"Mon Header"}>
            <h1>{toto}</h1>
            <p>{myfunction()}</p>
            <FirstApp initValue={5} placeHolder={"Entrez un nombre"}/>
        </MainLayout>
    );
};

export default App;