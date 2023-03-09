import {useEffect, useState} from "react";
import {DeadPersonGallery} from "./DeadPersonGallery";
import {createDeadPerson, getAllDeadPersons} from "../../service/apiService";
import {DeadPerson} from "../../models/DeadPerson";
import {CreateDeadPersonForm} from "./CreateDeadPersonForm";

export const DeadPersonApp = () => {
    const [deadPersons, setDeadPersons] = useState<DeadPerson[]>([]);

    useEffect(() => {
        getAllDeadPersons()
            .then((response) => setDeadPersons(response.data))
            .catch((error) => console.error(error));
    }, []);

    function addDeadPerson(deadPerson: DeadPerson) {
        createDeadPerson(deadPerson)
            .then((response) => setDeadPersons([...deadPersons, response.data]))
            .catch((error) => console.error(error));
    }

    return (
        <div>
            <CreateDeadPersonForm onAddDeadPerson={addDeadPerson}/>
            <DeadPersonGallery deadPersons={deadPersons}/>
        </div>
    );
}