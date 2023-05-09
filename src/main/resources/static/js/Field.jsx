// DataTable.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const DataTable = () => {
    const [tableData, setTableData] = useState([]);
    let table;
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
    }, []);

    return (
        table
    );
};

export default DataTable;
