import React, { StrictMode } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./css/index.css";
import styles from '../src/css/index.module.css';
import App from "./App";
import { Game } from "./pages/Game";
import TableComment from "./pages/TableComment";
import { ProSidebarProvider } from "react-pro-sidebar";
import Login from "./pages/Login";
import Leaderboard from "./pages/Leaderboard";
import CommentForm from "./pages/CommentForm";
import MyScore from "./pages/MyScore";
import StarRating from "./pages/Rating";


const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <div className={styles.background}>
    <BrowserRouter>
        <ProSidebarProvider>
            <Routes>
                <Route path="/" element={<App />}>
                    <Route index element={<Game />} />
                    <Route path="/game" element={<Game />} />
                    <Route path="/comment" element={<TableComment />} />
                    <Route path="/score" element={<Leaderboard />} />
                    <Route path="/addComment" element={<CommentForm />} />
                    <Route path="/myScore" element={<MyScore/>}/>
                    <Route path="/rating" element={<StarRating/>}/>
                </Route>
                <Route path="/login" element={<Login />} />
            </Routes>
        </ProSidebarProvider>
    </BrowserRouter>
    </div>
);
