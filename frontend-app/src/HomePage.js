import React from "react";
import { Sidebar, Menu, MenuItem, SubMenu, useProSidebar } from "react-pro-sidebar";
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import SportsEsportsIcon from '@mui/icons-material/SportsEsports';
import CommentIcon from '@mui/icons-material/Comment';
import AddCommentIcon from '@mui/icons-material/AddComment';
import RemoveRedEyeIcon from '@mui/icons-material/RemoveRedEye';
import SportsScoreIcon from '@mui/icons-material/SportsScore';
import LeaderboardIcon from '@mui/icons-material/Leaderboard';
import VisibilityIcon from '@mui/icons-material/Visibility';
import LoginIcon from '@mui/icons-material/Login';
import TableScore from "./pages/TableScore";
import { BrowserRouter as Router, Link, Route, Routes } from 'react-router-dom';

import { Game } from "./pages/Game";
import TableComment from "./pages/TableComment";
import CommentForm from "./pages/CommentForm";
import Leaderboard from "./pages/Leaderboard";
import {Login} from "./pages/Login";
import {RequireAuth} from "react-auth-kit";

function HomePage() {
    const { collapseSidebar } = useProSidebar();

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
                        <MenuItem icon={<SportsEsportsIcon />}>
                            <Link to="/game">Game</Link>
                        </MenuItem>
                        <SubMenu icon={<CommentIcon />} label="Comment">
                            <MenuItem icon={<AddCommentIcon />}>
                                <Link to="/addComment">Add comment</Link>
                            </MenuItem>
                            <MenuItem icon={<RemoveRedEyeIcon />}>
                                <Link to="/comment">See comment</Link>
                            </MenuItem>
                        </SubMenu>
                        <SubMenu icon={<SportsScoreIcon />} label="Score">
                            <MenuItem icon={< LeaderboardIcon/>}>
                                <Link to="/score">See top scores</Link>
                            </MenuItem>
                            <MenuItem icon={<VisibilityIcon />}>
                                See my score
                            </MenuItem>
                        </SubMenu>
                        <MenuItem icon={<LoginIcon/>}>
                            <Link to="/login">Login</Link>
                        </MenuItem>
                    </Menu>
                </Sidebar>
                <div className="pageContent">
                </div>
            </div>

    );
}

export default HomePage;
