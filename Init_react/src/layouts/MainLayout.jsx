import React from "react";

const MainLayout = ({children, title, ...props}) => {
    console.log(props);
    return (
        <>
            <header style={{ background: props.style.background, borderRadius: 5, padding: 5}}>
                <h1>{title}</h1>
            </header>
            {children}
            <footer style={{ background: props.style.background, borderRadius: 5, padding: 5}}>
                <h2>Mon footer</h2>
            </footer>
        </>
    )
}

export default MainLayout;