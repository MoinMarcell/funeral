import React from 'react';
import './App.css';
import {Route, Routes} from "react-router-dom";
import DeadPersonDetailsPage from "./components/deadPersons/DeadPersonDetailsPage";
import {DeadPersonGallery} from "./components/deadPersons/DeadPersonGallery";
import useDeadPersons from "./hooks/useDeadPersons";
import AddDeadPerson from "./components/deadPersons/AddDeadPerson";
import EditDeadPerson from "./components/deadPersons/EditDeadPerson";

function App() {

    const {deadPersons, isLoading} = useDeadPersons();

    return (
        <Routes>
            <Route path="/" element={<DeadPersonGallery isLoading={isLoading} deadPersons={deadPersons}/>}/>
            <Route path={"/dead-persons"}
                   element={<DeadPersonGallery isLoading={isLoading} deadPersons={deadPersons}/>}/>
            <Route path={"/dead-persons/:id"} element={<DeadPersonDetailsPage/>}/>
            <Route path={"/dead-persons/add"} element={<AddDeadPerson/>}/>
            <Route path={"/dead-persons/edit/:id"} element={<EditDeadPerson/>}/>
        </Routes>
    );
}

export default App;
