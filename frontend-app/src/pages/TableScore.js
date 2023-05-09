import React from 'react';
import {useState, useEffect} from "react";
import styles from '../css/stylesheeeet.module.css';
import {defaults} from "axios";

function TableScore(){
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
        <div className="App">
            {loading ? (
                <div>Loading...</div>
            ) : (
                <>
                    <h1>Scores</h1>
                    <table border={1}>
                        <tr>
                            <th>Name</th>
                            <th>Score</th>
                            <th>Played on</th>
                        </tr>
                        {users.map((user) => (
                            <tr key={user.id}>
                                <td>{user.player}</td>
                                <td>{user.points}</td>
                                <td>{user.playedOn}</td>
                            </tr>
                        ))}
                    </table>
                </>
            )}
        </div>
    );
}

export default TableScore;
