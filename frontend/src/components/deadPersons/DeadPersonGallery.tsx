import {DeadPerson} from "../../models/DeadPerson";
import {DeadPersonCard} from "./DeadPersonCard";

type DeadPersonGalleryProps = {
    deadPersons: DeadPerson[];
    isLoading: boolean;
}

export const DeadPersonGallery = (props: DeadPersonGalleryProps) => {

    const deadPersonCards = props.deadPersons.map((deadPerson) => {
        return <DeadPersonCard deadPerson={deadPerson} key={deadPerson.id}/>
    });

    const isEmpty: boolean = props.deadPersons.length === 0;

    if (props.isLoading) return <p>Loading...</p>

    return (
        <div>
            {
                isEmpty ? <p>Keine Todesfälle vorhanden</p> : deadPersonCards
            }
        </div>
    );
}