import React, { useState, useEffect } from 'https://esm.sh/react';
import ReactDOM from 'https://esm.sh/react-dom';
import axios from 'https://esm.sh/axios';

export const DataTable = () => {
    const [tableData, setTableData] = useState([]);
    let table;
    try {

    useEffect(() => {
        const fetchData = async () => {
            try {
                table = await axios.get('/TiltMaze/getField');
                setTableData(response.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);}catch (err){
        console.error('Error', err);
    }

    return (
        table
    );
};

function App() {
    return(DataTable);
}

ReactDOM.render(<App />, document.getElementById('gameField'));
if(document.getElementById('gameField'))
    alert("dasasasdsadsadsa");