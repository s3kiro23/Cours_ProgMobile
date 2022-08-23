import React, {useState} from "react";
import MyDiv from "./components/MyDiv.jsx";
import DataDisplay from "./components/DataDisplay.jsx";

const MyParagraph = ({children}) => {
    return (
        <div>
            {children}
        </div>
    )
}

const App = () => {
    const [name, setName] = useState("");
    const [isChecked, setIsChecked] = useState(false);

    const handleChangeName = (e) => {
        setName(e.target.value);
    }
    const handleClickCheckBox = () => {
        setIsChecked(!isChecked);
    }

    return (
        <>
            <MyDiv direction={isChecked ? "column" : "row"}>
                <h1>Bienvenue{name === "" ? "" : ", "} {name} !</h1>
                <input
                    type="text"
                    value={name}
                    onChange={handleChangeName}
                    style={{background: "lightgray", padding: 5, alignSelf: "center"}}
                />
            </MyDiv>
            <MyParagraph>
                <label
                    htmlFor={"conditions"}
                    style={{paddingRight: 5, cursor: "pointer"}}
                >
                    {isChecked ? "Case coché !" : "Veuillez cocher la case"}
                </label>
                <input
                    type="checkbox"
                    name="conditions"
                    id="conditions"
                    checked={isChecked}
                    onClick={handleClickCheckBox}
                    style={{cursor: "pointer"}}
                />
            </MyParagraph>
            <DataDisplay/>
        </>
    );
}

export default App