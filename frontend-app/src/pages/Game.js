import React, {useCallback} from 'react';
import axios from 'axios';
import styles from '../css/stylesheeeet.module.css';
import {stepClasses} from "@mui/material";
import ArrowButton from "./ArrowButton";
const { useState, useEffect } = React;

export const Game = () => {
    const [tableData, setTableData] = useState([]);
    const [showTable, setShowTable] = useState(false);
    const [field, setField] = useState([]);
    const [won, setWon] = useState(false);
    const [steps, setSteps] = useState();
    const [point, setPoint] = useState();

    const game = 'TiltMaze';
    let player = localStorage.getItem('username');
    const service = localStorage.getItem('service');

    const handleKeyPress = useCallback(async (event) => {
        let direction = 'West';
        if (event.key === 'ArrowUp' || event.key === 'ArrowDown' || event.key === 'ArrowLeft' || event.key === 'ArrowRight') {
            event.preventDefault();
        }
        setPoint(10);
        if(event.key === 'ArrowUp')
            direction = 'North';
        else if(event.key === 'ArrowDown')
            direction = 'South';
        else if(event.key === 'ArrowLeft')
            direction = 'West';
        else if(event.key === 'ArrowRight')
            direction = 'East';
    isWon();
        try {
            const response = await axios.get('http://localhost:8080/api/refresh-field?direction=' + direction);

            setField(response.data);

        } catch (error) {
            console.error('Error fetching data:', error);
        }


    }, []);

    useEffect(() => {

        window.addEventListener('keydown', handleKeyPress);

        return () => {
            window.removeEventListener('keydown', handleKeyPress);
        };
    }, [handleKeyPress]);

    const handleClick = async (direction) => {
        try {
            const response = await axios.get('http://localhost:8080/api/refresh-field?direction=' + direction);
            setTableData(response.data);
            setField(response.data);

        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };
    const fetchFieldData = async () => {
        try {
            isWon();

            const response = await fetch("http://localhost:8080/api/field");
            const data = await response.json();
            setField(data);
            console.log(data);
        } catch (error) {
            console.error("dss");
        }
    };


    const isWon = async () => {
        try {
            getSteps();
            const response = await axios.get('http://localhost:8080/api/isWon');
            setWon(response.data);
            if(response.data === 'true')
                points();
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };


    useEffect(() => {
        fetchFieldData();
        getSteps();

    }, [handleKeyPress]);


    const newGame = async() => {
        try {
         await axios.get('http://localhost:8080/api/newGame');
            fetchFieldData();
            setWon(false);
        }
        catch (error){
            console.error('Error fetching data:', error);
        }
    };

    const getSteps = async () =>{
        try {
            const response = await axios.get("http://localhost:8080/api/steps");
            setSteps(response.data);

        }
        catch (error){
            console.log(error);
        }
    };

    const points = async () => {
        try {
            const scoreData = {
                player,
                game,
                playedOn: new Date(),
                points: 10,
            };

            await axios.post('http://localhost:8080/api/score', scoreData);
        } catch (error) {
            console.error('Error updating rating:', error);
        }
    };

    if(!won){
    return (
        <div className={`${styles.background} ${styles.blur}`}>
            <div className={styles.center}>

                <div className={styles.fieldFrame}>
                    {field.map((row, rowIndex) => (
                        <div key={rowIndex} style={{ display: "flex" }}>
                            {row.map((tile, colIndex) => (
                                <div key={colIndex} className={`${styles.tile}`}>
                                    {tile.upBlocked && (<div className={`${styles.topWall} ${styles.wall}`} />)}
                                    {tile.downBlocked && (<div className={`${styles.bottomWall} ${styles.wall}`} />)}
                                    {tile.leftBlocked && (<div className={`${styles.leftWall} ${styles.wall}`} />)}
                                    {tile.rightBlocked && (<div className={`${styles.rightWall} ${styles.wall}`} />)}
                                    {tile.reached &&(<div className={tile.playerPresent ? styles.player : styles.reached}></div>)}
                                    <div className={tile.playerPresent ? styles.player : tile.reached ? styles.reached : ''}></div>
                                </div>
                            ))}
                        </div>
                    ))}
                </div>
                <div className={styles.row}>
                    <ArrowButton direction="West" onClick={() => handleClick('West')} />
                    <ArrowButton direction="East" onClick={() => handleClick('East')} />
                    <ArrowButton direction="North" onClick={() => handleClick('North')} />
                    <ArrowButton direction="South" onClick={() => handleClick('South')} />
                    </div>
            <div className={styles.restart}>
                <button className={styles.button} onClick={() => newGame()}>RESTART</button>
            </div>
                </div>
            </div>


    );}
    else {
        return (
            <div className={`${styles.background} ${styles.blur}`}>
                <div className={styles.center}>
                    <div className={styles.winnerBanner}>
                        <div className={styles.winnerText}>WINNER</div>
                        <div className={styles.winnerText}>WINNER</div>
                        <div className={styles.winnerText}>CHICKEN</div>
                        <div className={styles.winnerText}>DINNER</div>
                        <div className={styles.restart}>
                            <button className={styles.button} onClick={() => newGame()}>RESTART</button>
                        </div>

                    </div>
                    <div className={styles.winnerText2}>
                        <h2>You make</h2>
                        <h2>{steps} steps and get {point} points</h2>
                    </div>
                </div>
            </div>
        );

    }

};
