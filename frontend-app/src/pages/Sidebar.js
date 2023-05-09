import React from 'react';
import {Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import { Link } from 'react-router-dom';
import 'react-pro-sidebar/dist/css/styles.css';

const Sidebarr = () => {
    return (
        <Sidebar>
            <Menu iconShape="square">
                <MenuItem>
                    <Link to="/">Home</Link>
                </MenuItem>
                <MenuItem>
                    <Link to="/about">About</Link>
                </MenuItem>
            </Menu>
        </Sidebar>
    );
};

export default Sidebarr;