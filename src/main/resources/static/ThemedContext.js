// ThemedContent.js

import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';

const ThemedContent = () => {
    const { theme, toggleTheme } = useContext(ThemeContext);

    const themeStyles = {
        light: {
            backgroundColor: 'white',
            color: 'black',
        },
        dark: {
            backgroundColor: 'black',
            color: 'white',
        },
    };

    return (
        <div style={themeStyles[theme]}>
            <h1>Theme Switcher</h1>
            <p>Current theme: {theme}</p>
            <button onClick={toggleTheme}>Toggle Theme</button>
        </div>
    );
};

export default ThemedContent;