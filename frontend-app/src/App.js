import React, {useState, useEffect} from "react";
import { Sidebar, Menu, MenuItem, SubMenu, useProSidebar } from "react-pro-sidebar";

import {BrowserRouter, BrowserRouter as Router, Link, Outlet, Route, Routes, useNavigate} from 'react-router-dom';

import { Game } from "./pages/Game";
import TableComment from "./pages/TableComment";
import CommentForm from "./pages/CommentForm";
import Leaderboard from "./pages/Leaderboard";
import {Login} from "./pages/Login";
import {RequireAuth} from "react-auth-kit";
import {Home} from "@mui/icons-material";
import HomePage from "./HomePage";
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import SportsEsportsIcon from "@mui/icons-material/SportsEsports";
import CommentIcon from "@mui/icons-material/Comment";
import AddCommentIcon from "@mui/icons-material/AddComment";
import RemoveRedEyeIcon from "@mui/icons-material/RemoveRedEye";
import SportsScoreIcon from "@mui/icons-material/SportsScore";
import LeaderboardIcon from "@mui/icons-material/Leaderboard";
import VisibilityIcon from "@mui/icons-material/Visibility";
import LoginIcon from "@mui/icons-material/Login";

function App() {
    const navigate = useNavigate();
    const { collapseSidebar } = useProSidebar();
    const [authenticated, setauthenticated] = useState(null);
    useEffect(() => {
        const loggedInUser = localStorage.getItem("authenticated");
        if (loggedInUser) {
            setauthenticated(loggedInUser);
        }
    }, []);

    if(!authenticated){

    }else
    return (
        <div id="app" style={({ height: "100vh" }, { display: "flex" })}>
            <Sidebar style={{ height: "100vh" }}>
                <Menu>
                    <MenuItem
                        icon={<MenuOutlinedIcon />}
                        onClick={() => {
                            collapseSidebar();
                        }}
                        style={{ textAlign: "center" }}
                    >
                        <h2>TiltMaze</h2>
                    </MenuItem>
                    <MenuItem icon={<SportsEsportsIcon />}
                        onClick={() =>{
                            navigate('/game');
                        }}

                    >
                       <h1>Game</h1>
                    </MenuItem>
                    <SubMenu icon={<CommentIcon />} label="Comment">
                        <MenuItem icon={<AddCommentIcon />}
                                  onClick={() =>{
                                      navigate('/addComment');
                                  }}

                        >
                            <h1>Add comment</h1>
                        </MenuItem>
                        <MenuItem icon={<RemoveRedEyeIcon />}
                                  onClick={() =>{
                                      navigate('/comment');
                                  }}

                        >
                            <h1>Comments</h1>
                        </MenuItem>
                    </SubMenu>
                    <SubMenu icon={<SportsScoreIcon />} label="Score">
                        <MenuItem icon={<LeaderboardIcon />}
                                  onClick={() =>{
                                      navigate('/score');
                                  }}

                        >
                            <h1>Leaderboard</h1>
                        </MenuItem>
                        <MenuItem icon={<VisibilityIcon />}>
                            See my score
                        </MenuItem>
                    </SubMenu>
                    <MenuItem icon={<LoginIcon />}
                              onClick={() =>{
                                  navigate('/login');
                              }}

                    >
                        <h1>Login</h1>
                    </MenuItem>
                </Menu>
            </Sidebar>
            <div className="pageContent">
                <Outlet/>
            </div>
        </div>
    );
}

export default App;
