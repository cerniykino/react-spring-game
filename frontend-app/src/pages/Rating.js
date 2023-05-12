import React, { useEffect, useState } from 'react';
import Rating from 'react-rating';
import styles from '../css/rating.module.css';
import axios from 'axios';
import login from "./Login";
import {useNavigate} from "react-router-dom";

function StarRating() {
    const [userRating, setUserRating] = useState(0);
    const [currentRating, setCurrentRating] = useState(0);
    const navigate = useNavigate();
    const game = 'TiltMaze';
    let player = localStorage.getItem('username');
    let authenticated = localStorage.getItem("service");
    console.log(authenticated);
    useEffect(() => {
        async function fetchRating() {
            try {
                const response = await axios.get(`http://localhost:8080/api/rating/${game}`);
                setCurrentRating(response.data);
            } catch (error) {
                console.error('Error fetching rating:', error);
            }
        }

        fetchRating();
    }, []);

    const handleRatingChange = async (value) => {
        try {
            setUserRating(value);
            const ratingData = {
                player,
                game,
                rating: value,
                ratedOn: new Date(),
            };
            await axios.post('http://localhost:8080/api/rating', ratingData);
        } catch (error) {
            console.error('Error updating rating:', error);
        }
    };
    if(authenticated === 'true')
    return (
        <div className={`${styles.background} ${styles.center}`}>
            <div className={styles.ratingContainer}>
                <h2>Average Rating</h2>
                <Rating
                    initialRating={currentRating}
                    readonly
                    emptySymbol={<i className={`far fa-star ${styles.emptyStar}`}></i>}
                    fullSymbol={<i className={`fas fa-star ${styles.fullStar}`}></i>}
                />

                <h2>Rate this game</h2>

                <Rating
                    initialRating={userRating}
                    onChange={handleRatingChange}
                    emptySymbol={<i className={`far fa-star ${styles.emptyStar}`}></i>}
                    fullSymbol={<i className={`fas fa-star ${styles.fullStar}`}></i>}
                />
                <div className={styles.userRatingText}>
                    You rated this game {userRating} star{userRating === 1 ? '' : 's'}.
                </div>
            </div>
        </div>
    );

    else
        return (
            <div className={`${styles.background} ${styles.center}`}>
                <div className={styles.ratingContainer}>
                    <h2>Average Rating</h2>
                    <Rating
                        initialRating={currentRating}
                        readonly
                        emptySymbol={<i className={`far fa-star ${styles.emptyStar}`}></i>}
                        fullSymbol={<i className={`fas fa-star ${styles.fullStar}`}></i>}
                    />

                    <h2>You must be logged to rate game</h2>
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

export default StarRating;
