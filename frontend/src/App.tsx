import React from 'react';
import './App.css';
import {DeadPersonApp} from "./components/deadPersons/DeadPersonApp";
import {Route, Routes} from "react-router-dom";
import DeadPersonDetailsPage from "./components/deadPersons/DeadPersonDetailsPage";

function App() {
    return (
        <Routes>
            <Route path="/" element={<DeadPersonApp/>}/>
            <Route path={"/dead-persons"} element={<DeadPersonApp/>}/>
            <Route path={"/:id"} element={<DeadPersonDetailsPage/>}/>
        </Routes>
    );
}

export default App;
