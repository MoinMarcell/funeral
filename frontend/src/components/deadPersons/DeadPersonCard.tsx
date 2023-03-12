import {DeadPerson} from "../../models/DeadPerson";
import {useNavigate} from "react-router-dom";

type DeadPersonCardProps = {
    deadPerson: DeadPerson;
}

export const DeadPersonCard = (props: DeadPersonCardProps) => {

    const navigate = useNavigate();

    function handleDetailsClick() {
        navigate("/dead-persons/" + props.deadPerson.id);
    }

    return (
        <div>
            <h1>{props.deadPerson.firstName} {props.deadPerson.lastName}</h1>
            <p>Gestorben am: {props.deadPerson.dateOfDeath}</p>
            <button onClick={handleDetailsClick}>Details</button>
        </div>
    );
}