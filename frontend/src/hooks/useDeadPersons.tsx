import {deleteDeadPerson, getAllDeadPersons} from "../service/apiService";
import {useEffect, useState} from "react";
import {DeadPerson} from "../models/DeadPerson";

export default function useDeadPersons() {

    const [deadPersons, setDeadPersons] = useState<DeadPerson[]>([]);
    const [isLoading, setIsLoading] = useState<boolean>(false);
    const [error, setError] = useState<Error | null>(null);

    useEffect(() => {
        setIsLoading(true);
        getAllDeadPersons()
            .then((response) => {
                setIsLoading(false);
                setDeadPersons(response.data);
            })
            .catch((error) => {
                setIsLoading(false);
                setError(error);
            });
    }, []);

    function deleteDeadPersonById(id: string) {
        deleteDeadPerson(id)
            .then(() => {
                setDeadPersons(deadPersons.filter((deadPerson) => deadPerson.id !== id));
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return {deadPersons, isLoading, error, deleteDeadPersonById};

}