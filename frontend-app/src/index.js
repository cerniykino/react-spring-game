import React, { StrictMode } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./css/index.css";
import App from "./App";
import { Game } from "./pages/Game";
import TableComment from "./pages/TableComment";
import { ProSidebarProvider } from "react-pro-sidebar";
import Login from "./pages/Login";
import Leaderboard from "./pages/Leaderboard";
import CommentForm from "./pages/CommentForm";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <BrowserRouter>
        <ProSidebarProvider>
            <Routes>
                <Route path="/" element={<App />}>
                    <Route index element={<Game />} />
                    <Route path="/game" element={<Game />} />
                    <Route path="/comment" element={<TableComment />} />
                    <Route path="/score" element={<Leaderboard />} />
                    <Route path="/addComment" element={<CommentForm />} />
                </Route>
                <Route path="/login" element={<Login />} />
            </Routes>
        </ProSidebarProvider>
    </BrowserRouter>
);
