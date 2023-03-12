import {DeadPersonForm} from "./DeadPersonForm";
import {DeadPerson} from "../../models/DeadPerson";
import {createDeadPerson} from "../../service/apiService";
import {useNavigate} from "react-router-dom";

export default function AddDeadPerson() {

    const navigate = useNavigate();

    function handleDeadPerson(deadPerson: DeadPerson) {
        createDeadPerson(deadPerson)
            .then((response) => navigate('/dead-persons/' + response.data.id))
            .catch(error => console.error(error));
    }

    return (
        <DeadPersonForm handleDeadPerson={handleDeadPerson}/>
    );
}