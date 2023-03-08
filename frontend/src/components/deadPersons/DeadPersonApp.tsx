import {useEffect, useState} from "react";
import {DeadPersonGallery} from "./DeadPersonGallery";
import {getAllDeadPersons} from "../../service/apiService";
import {DeadPerson} from "../../models/DeadPerson";

export const DeadPersonApp = () => {
    const [deadPersons, setDeadPersons] = useState<DeadPerson[]>([]);

    useEffect(() => {
        getAllDeadPersons()
            .then((response) => setDeadPersons(response.data))
            .catch((error) => console.error(error));
    }, []);

    return (
        <div>
            <DeadPersonGallery deadPersons={deadPersons}/>
        </div>
    );
}