import React, { useState } from "react";
import styles from "../css/comment.module.css";
import {useNavigate} from "react-router-dom";
import axios from "axios";

export default function CommentForm() {
    const [name, setName] = useState("");
    const [comment, setComment] = useState("");
    const [service] = useState(localStorage.getItem(localStorage.getItem("service")|| false));
    const navigate = useNavigate();
    console.log(service);
    const submitComment = async (game, player, comment) => {
        const url = "http://localhost:8080/api/comment";
        const data = {
            game,
            player,
            commentedOn: new Date(),
            comment,
        };

        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        });

        if (response.ok) {
            console.log("Comment submitted successfully");
        } else {
            console.error("Error submitting comment");
        }
    };
    const handleSubmit = async (event) => {
        event.preventDefault();
        const game = "TiltMaze";
        const player =localStorage.getItem("username");
        const commentText = `${comment}`;

        await submitComment(game, player, commentText);
    };


    if(localStorage.getItem("service") === 'true'){
    return (
        <div className={`${styles.background} ${styles.center}`}>
            <div className={styles.formContainer}>
                <div className={styles.title}>Write comment</div>
                <div className={styles.gap}/>
            <div className={styles.comment}>
                <form onSubmit={handleSubmit}>
                    <div className={styles.gap}/>
                        <textarea id ="comment" className={styles.input}
                            type="text"
                            value={comment}
                            onChange={(event) => setComment(event.target.value)}
                                  placeholder="Comment"
                         required/>
                    <label for="id" className={styles.placeholder}></label>
                    <button type="text" className={styles.submit}>Submit</button>
                </form>
                </div>
            </div>
        </div>
     );}
    else
        return (
            <div className={`${styles.background} ${styles.center}`}>
                <div className={styles.formContainer}>
                    <div className={styles.title}>
                        You must be registered to leave a comment
                    </div>
                    <div className={styles.gap} />
                    <button
                        type="button"
                        className={styles.submit}
                        onClick={() => navigate("/login")} // Add this line to navigate to the login page
                    >
                        Go to Login
                    </button>
                </div>
            </div>);
}
