import React from "react";

const MyDiv = ({children, direction}) => {

    return (
        <div
            style={{
                display: "flex",
                flexDirection: direction,
                gap: "20px"
            }}>
            {children}
        </div>
    )
}

export default MyDiv