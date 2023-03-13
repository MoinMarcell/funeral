import {DeadPersonForm} from "./DeadPersonForm";
import {DeadPerson} from "../../models/DeadPerson";
import {updateDeadPerson} from "../../service/apiService";
import {useNavigate, useParams} from "react-router-dom";
import useDeadPerson from "../../hooks/useDeadPerson";

export default function EditDeadPerson() {

    const navigate = useNavigate();

    const params = useParams();
    const id: string | undefined = params.id;

    const {deadPerson} = useDeadPerson(id ? id : '');

    function handleDeadPerson(deadPerson: DeadPerson) {
        if (!id) return <p>Dead Person not found</p>
        updateDeadPerson(id, deadPerson)
            .then((response) => navigate('/dead-persons/' + response.data.id))
            .catch(error => console.error(error));
    }

    return (
        <DeadPersonForm handleDeadPerson={handleDeadPerson} deadPerson={deadPerson}/>
    );
}