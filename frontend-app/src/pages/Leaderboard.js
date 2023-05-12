import React from 'react';
import { useState, useEffect } from "react";
import styles from '../css/leaderboard.module.css';
import { defaults } from "axios";

function Leaderboard() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        fetch("http://localhost:8080/api/score/TiltMaze")
            .then((response) => response.json())
            .then((json) => setUsers(json))
            .finally(() => {
                setLoading(false);
            });
    }, []);

    return (
        <div className={`${styles.background} ${styles.center}`}>
            <div className={styles.title}>Leaderboard</div>
            <div className={styles.scoreContainer}>
                {users.map((user) => (
                    <div key={user.id} className={styles.scoreCard}>
                        <div className={styles.username}>{user.player}</div>
                        <div className={styles.points}>{user.points}</div>
                        <div className={styles.gap}></div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Leaderboard;
