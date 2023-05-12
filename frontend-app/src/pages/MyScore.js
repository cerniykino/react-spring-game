import React, {useEffect, useState} from 'react';
import styles from "../css/score.module.css";
import axios from "axios";
import {useNavigate} from "react-router-dom";


function MyScore() {
    const [loading, setLoading] = useState(false);
    const [player, setPlayer] = useState(null);
    let authenticated = localStorage.getItem("service");
    const navigate = useNavigate();
    useEffect(() => {
        (async () => {
            setLoading(true);
            let username = localStorage.getItem("username");
            try {
                const response = await axios.get("http://localhost:8080/api/score/TiltMaze/" + username);
                setPlayer(response.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false);
        })();
    }, []);
    if(authenticated === 'true')
    return (
        <div className={`${styles.background} ${styles.center}`}>
            {player && (
                <div className={styles.scoreContainer}>
                    <div className={styles.scoreCard}>

                    <div className={styles.username}>{player.player}</div>
                    <div className={styles.points}>{player.points}</div>
                        </div>
                </div>
            )}
            {!player && (
                <div className={styles.scoreContainer}>
                        <h1>Nothing to show</h1>
                </div>
            )}
        </div>
    );
    else
        return (
            <div className={`${styles.background} ${styles.center}`}>
                <div className={styles.scoreContainer}>
                <h2>You must be logged to see your game score</h2>
                <button
                    type="button"
                    className={styles.submit}
                    onClick={() => navigate("/login")} // Add this line to navigate to the login page
                >
                    Go to Login
                </button>
                    </div>
            </div>
        );


}

export default MyScore;
