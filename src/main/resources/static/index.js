import React, { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import {ThemedContent} from "./ThemedContext.js";
function Profile() {
    return (
        <img
            src="https://i.imgur.com/MK3eW3As.jpg"
            alt="Katherine Johnson"
        />
    );
}

let App = function Gallery() {
    return (
        <section>
            <h1>Amazing scientists</h1>
            <Profile />
            <Profile />
            <Profile />
        </section>
    );
}


const root = createRoot(document.getElementById('root'));
root.render(
    <StrictMode>
        <ThemedContent />
    </StrictMode>
);