import React, { useState } from "react";
import styles from "../css/login.module.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const [authenticated, setauthenticated] = useState(localStorage.getItem(localStorage.getItem("authenticated")|| false));
    const [service, setService] = useState(localStorage.getItem(localStorage.getItem("service")|| false));
    const [activeForm, setActiveForm] = useState('signin');
    const users = [{ username: "Jane", password: "testpassword" }];

    const handleSubmitLogin = async (e) => {
        e.preventDefault()
        localStorage.setItem(`${username}`, `${password}`);

        const responseLogin = await axios.get('http://localhost:8080/api/user/login?username='+`${username}`+'&password=' +`${password}`);

        if (responseLogin.data === true) {
            setauthenticated(true)
            localStorage.setItem("service", 'true');
            localStorage.setItem("authenticated", 'true');
            localStorage.setItem("username", `${username}`);
        }

        if(authenticated) {
            navigate("/");
        }
    };
    const handleGuestLogin = () => {

        localStorage.setItem("service", 'false');
        navigate("/");
    };

    const handleSubmitRegister = async(e) =>{
        e.preventDefault()
        localStorage.setItem(`${username}`, `${password}`);
        const responseRegister = await axios.get('http://localhost:8080/api/user/register?username='+`${username}`+'&password=' +`${password}`);

        if (responseRegister.data === true) {
            setauthenticated(true)
            localStorage.setItem("service", 'true');
            localStorage.setItem("authenticated", 'true');
            localStorage.setItem("username", `${username}`);
        }

        if(authenticated) {
            navigate("/");
        }
    }

    return (
        <div className={styles.container}>
            <form onSubmit={activeForm === 'signin' ? handleSubmitLogin : handleSubmitRegister} className={styles.loginForm}>
                <div className={styles.switchContainer}>
                    <form className={styles.toggle}>
                        <input
                            type="radio"
                            id="choice1"
                            name="choice"
                            value="signin"
                            checked={activeForm === 'signin'}
                            onChange={() => setActiveForm('signin')}
                        />
                        <label
                            htmlFor="choice1"
                            className={activeForm === 'signin' ? styles.active : ''}
                        >
                            Sign in
                        </label>

                        <input
                            type="radio"
                            id="choice2"
                            name="choice"
                            value="signup"
                            checked={activeForm === 'signup'}
                            onChange={() => setActiveForm('signup')}
                        />
                        <label
                            htmlFor="choice2"
                            className={activeForm === 'signup' ? styles.active : ''}
                        >
                            Sign up
                        </label>


                    </form>
                </div>
                <h2 className={styles.title}>{activeForm === 'signin' ? 'Login' : 'Register'}</h2>
                <label htmlFor="email" className={styles.label}>
                    Email:
                    <input

                        id="email"
                        value={username}
                        onChange={(event) => setUsername(event.target.value)}
                        className={styles.input}
                        required
                    />
                </label>
                <label htmlFor="password" className={styles.label}>
                    Password:
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(event) => setPassword(event.target.value)}
                        className={styles.input}
                        required
                    />
                </label>
                <button type="submit" className={styles.submitButton} >
                    {activeForm === 'signin' ? 'Login' : 'Register'}
                </button>
                <button
                    type="button"
                    onClick={handleGuestLogin}
                    className={`${styles.submitButton} ${styles.guestButton}`}
                >
                    Login as Guest
                </button>
            </form>
        </div>
    );
}

export default Login;
