import {DeadPerson} from "../models/DeadPerson";
import {useEffect, useState} from "react";
import {getDeadPerson} from "../service/apiService";

export default function useDeadPerson(id: string) {
    const [deadPerson, setDeadPerson] = useState<DeadPerson | undefined>(undefined);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<Error | undefined>(undefined);

    useEffect(() => {
        setLoading(true);
        getDeadPerson(id)
            .then((response) => {
                setDeadPerson(response.data);
                setLoading(false);
            })
            .catch((error) => {
                setError(error);
                setLoading(false);
            });
    }, [id]);

    return {deadPerson, loading, error};
}