import React from 'react';
import { useState, useEffect } from "react";
import styles from '../css/stylesheeeet.module.css';
import { defaults } from "axios";

function TableComment() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        fetch("http://localhost:8080/api/comment/TiltMaze")
            .then((response) => response.json())
            .then((json) => setUsers(json))
            .finally(() => {
                setLoading(false);
            });
    }, []);

    return (
        <div className="App">
            {loading ? (
                <div>Loading...</div>
            ) : (
                <>
                    <h1>Comments</h1>
                    <div className={styles.commentsContainer}>
                        {users.map((user) => (
                            <div key={user.id} className={styles.commentCard}>
                                <div className={styles.commentHeader}>
                                    <div className={styles.userName}>{user.player}</div>
                                    <div className={styles.commentDate}>{user.commentedOn}</div>
                                </div>
                                <div className={styles.commentContent}>{user.comment}</div>
                            </div>
                        ))}
                    </div>
                </>
            )}
        </div>
    );
}

export default TableComment;
