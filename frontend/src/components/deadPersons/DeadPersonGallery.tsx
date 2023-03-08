import {DeadPerson} from "../../models/DeadPerson";
import {DeadPersonCard} from "./DeadPersonCard";

type DeadPersonGalleryProps = {
    deadPersons: DeadPerson[];
}

export const DeadPersonGallery = (props: DeadPersonGalleryProps) => {

    const deadPersonCards = props.deadPersons.map((deadPerson) => {
        return <DeadPersonCard deadPerson={deadPerson} key={deadPerson.id}/>
    });

    const isEmpty: boolean = deadPersonCards.length === 0;

    return (
        <div>
            {
                isEmpty ? <p>Keine Todesfälle vorhanden</p> : deadPersonCards
            }
        </div>
    );
}