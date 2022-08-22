import React, {useState} from "react";
import {data} from "../utils/data";

const FirstApp = ({initValue, placeHolder}) => {
    const [count, setCount] = useState(0);
    const [value, setValue] = useState(initValue);

    const increment = () => {
        if (count + value >= 0) (setCount((elem) => elem + value));
        else setCount(0);
    };

    const [input, setInput] = useState("");
    const checkInput = () => {
        const tmp = parseInt(input);
        if (isNaN(tmp)) {
            alert("Merci de saisir un nombre...")
        } else {
            setValue(tmp)
        }
        setInput("");
    }

    const validateInputWithEnter = (e) => {
        if (e.key === "Enter") {
            checkInput();
        }
    }

    return (
        <>
            <p>{count}</p>
            <button onClick={increment}>
                {value > 0 ? ("+") : ("")}
                {value}
            </button>
            <br/>
            <br/>
            <input
                type="text"
                value={input}
                onChange={(event) => setInput(event.target.value)}
                onKeyDown={validateInputWithEnter}
                placeholder={placeHolder}
            />
            <button onClick={checkInput}>Set</button>
            {count >= 100 && count < 200 && (
                <h2>Mon compte est supérieur à 100!</h2>
            )}
            {count > 50 && count < 100 ? (
                <h3>Mon compte est supérieur à 50 ! </h3>
            ) : (
                <h3>Mon compte est inférieur 50...</h3>
            )}
            {data.map(({id, firstName, lastName, age}) => (
                <div key={id}>
                    <p>{firstName} {lastName} - {age} ans</p>
                </div>
            ))}
        </>
    );
};

export default FirstApp;