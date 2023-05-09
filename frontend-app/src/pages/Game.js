import React, {useCallback} from 'react';
import axios from 'axios';
import styles from '../css/stylesheeeet.module.css';
import {stepClasses} from "@mui/material";

const { useState, useEffect } = React;

export const Game = () => {
    const [tableData, setTableData] = useState([]);
    const [showTable, setShowTable] = useState(false);
    const [field, setField] = useState([]);



    const handleKeyPress = useCallback(async (event) => {
        let direction = 'West';


        if(event.key === 'ArrowUp')
            direction = 'North';
        else if(event.key === 'ArrowDown')
            direction = 'South';
        else if(event.key === 'ArrowLeft')
            direction = 'West';
        else if(event.key === 'ArrowRight')
            direction = 'East';


        try {
            const response = await axios.get('http://localhost:8080/api/refresh-field?direction=' + direction);
            setTableData(response.data);
            setField(response.data);
            return Promise.resolve();
        } catch (error) {
            console.error('Error fetching data:', error);
            return Promise.reject();
        }
    }, []);

    useEffect(() => {
        // attach the event listener
        document.addEventListener('keydown', handleKeyPress);

        // remove the event listener
        return () => {
            document.removeEventListener('keydown', handleKeyPress);
        };
    }, [handleKeyPress]);
    const handleClick = async (direction) => {
        try {
            const response = await axios.get('http://localhost:8080/api/refresh-field?direction=' + direction);
            setTableData(response.data);
            setField(response.data);
            return Promise.resolve();
        } catch (error) {
            console.error('Error fetching data:', error);
            return Promise.reject();
        }
    };

    useEffect(() => {
        fetchFieldData();
    }, []);

    const fetchFieldData = async () => {
        try {
            const response = await fetch("http://localhost:8080/api/field");
            const data = await response.json();
            setField(data);
            console.log(data);
        }
        catch (error){
            console.error("dss");
        }
    };

    const handleTableButtonClick = () => {
        setShowTable(!showTable);
    };


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
                <div>
                    <button className={`${styles.button} ${styles.circularLeft}`} onClick={() => handleClick('West')} />
                    <button className={`${styles.button} ${styles.circularRight}`} onClick={() => handleClick('East')} />
                    <button className={`${styles.button} ${styles.circularUp}`} onClick={() => handleClick('North')}/>
                    <button className={`${styles.button} ${styles.circularDown}`} onClick={() => handleClick('South')} />
                </div>
            </div>
        </div>

    );
};
