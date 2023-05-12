import React, {useState, useEffect} from "react";
import { Sidebar, Menu, MenuItem, SubMenu, useProSidebar } from "react-pro-sidebar";

import {BrowserRouter, BrowserRouter as Router, Link, Outlet, Route, Routes, useNavigate} from 'react-router-dom';
import styles from './css/menu.module.css';
import { Game } from "./pages/Game";
import TableComment from "./pages/TableComment";
import CommentForm from "./pages/CommentForm";
import Leaderboard from "./pages/Leaderboard";
import {Login} from "./pages/Login";

import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import SportsEsportsIcon from "@mui/icons-material/SportsEsports";
import CommentIcon from "@mui/icons-material/Comment";
import AddCommentIcon from "@mui/icons-material/AddComment";
import RemoveRedEyeIcon from "@mui/icons-material/RemoveRedEye";
import SportsScoreIcon from "@mui/icons-material/SportsScore";
import LeaderboardIcon from "@mui/icons-material/Leaderboard";
import VisibilityIcon from "@mui/icons-material/Visibility";
import LoginIcon from "@mui/icons-material/Login";
import GradeIcon from '@mui/icons-material/Grade';


const CustomLabel = ({ text, className }) => {
    return <span className={className}>{text}</span>;
};


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
        <div id="app" style={{ width: "100%", display: "flex" }}>
            <div style={{ display: "flex", flexDirection: "row", flex: 1 }}>
                <Sidebar style={{ height: "100vh", minWidth: "80px", zIndex: 2 }}>
                    <div style={{zIndex: 1}}>
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
                    <SubMenu icon={<CommentIcon />}  label={<CustomLabel text="Comment" className={styles.menuItemLabel}/>} disableScrollLock={true}>
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
                    <SubMenu icon={<SportsScoreIcon />} label={<CustomLabel text="Score" className={styles.menuItemLabel} />} disableScrollLock={true}>
                        <MenuItem icon={<LeaderboardIcon />}
                                  onClick={() =>{
                                      navigate('/score');
                                  }}

                        >
                            <h1>Leaderboard</h1>
                        </MenuItem>
                        <MenuItem icon={<VisibilityIcon />} onClick={() =>{
                            navigate('/myScore');
                        }}>
                            <h1>See my score</h1>
                        </MenuItem>
                    </SubMenu>
                    <MenuItem icon={<GradeIcon />}
                              onClick={() =>{
                                  navigate('/rating');
                              }}

                    >
                        <h1>Rating</h1>
                    </MenuItem>
                    <MenuItem icon={<LoginIcon />}
                              onClick={() =>{
                                  navigate('/login');
                              }}

                    >
                        <h1>Login</h1>
                    </MenuItem>

                </Menu>
                        </div>
            </Sidebar>
                <div className="pageContent" style={{ flex: 1 }}>
                <Outlet/>
            </div>
        </div>
        </div>
    );
}

export default App;
