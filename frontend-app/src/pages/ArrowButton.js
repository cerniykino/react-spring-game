import React from 'react';
import styles from '../css/stylesheeeet.module.css';

const ArrowButton = ({direction, onClick }) => {
    const arrowDirection = {
        North: { transform: "rotate(270deg)" },
        South: { transform: "rotate(90deg)" },
        West: { transform: "rotate(180deg)" },
        East: { transform: "rotate(0deg)" },
    };
    const handleClick = (direction) => {
        onClick(direction);
    };
    if(direction === 'North')
    return (
        <div className={styles.arrowButtons}>
            <div className={styles.round} onClick={() => handleClick('North')}>
                <div className={styles.cta}>

                    <span className={`${styles.arrow} ${styles.primera} ${styles.next} ${styles.roundNorth}`} />
                    <span className={`${styles.arrow} ${styles.segunda} ${styles.next} ${styles.roundNorth}`} />

                </div>

            </div>
        </div>
    );
    if(direction === 'South')
        return (
            <div className={styles.arrowButtons}>
                <div className={styles.round} onClick={() => handleClick('South')}>
                    <div className={styles.cta}>

                        <span className={`${styles.arrow} ${styles.primera} ${styles.next} ${styles.roundSouth}`} />
                        <span className={`${styles.arrow} ${styles.segunda} ${styles.next} ${styles.roundSouth}`} />

                    </div>

                </div>
            </div>
        );
    if(direction === 'East')
        return (
            <div className={styles.arrowButtons}>
                <div className={styles.round} onClick={() => handleClick('East')}>
                    <div className={styles.cta}>

                        <span className={`${styles.arrow} ${styles.primera} ${styles.next} `} />
                        <span className={`${styles.arrow} ${styles.segunda} ${styles.next} `} />

                    </div>

                </div>
            </div>
        );
    if(direction === 'West')
        return (
            <div className={styles.arrowButtons}>
                <div className={styles.round} onClick={() => handleClick('West')}>
                    <div className={styles.cta}>

                        <span className={`${styles.arrow} ${styles.primera} ${styles.next} ${styles.roundWest}`} />
                        <span className={`${styles.arrow} ${styles.segunda} ${styles.next} ${styles.roundWest}`} />

                    </div>

                </div>
            </div>
        );
};

export default ArrowButton;
