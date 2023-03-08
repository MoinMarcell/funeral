import {DeadPerson} from "../../models/DeadPerson";

type DeadPersonCardProps = {
    deadPerson: DeadPerson;
}

export const DeadPersonCard = (props: DeadPersonCardProps) => {
    return (
        <div>
            <h1>{props.deadPerson.firstName} {props.deadPerson.lastName}</h1>
            <p>Gestorben am: {props.deadPerson.dateOfDeath}</p>
        </div>
    );
}