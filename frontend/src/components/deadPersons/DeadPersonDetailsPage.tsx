import {DeadPerson} from "../../models/DeadPerson";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {getDeadPerson} from "../../service/apiService";

export default function DeadPersonDetailsPage() {

    const [deadPerson, setDeadPerson] = useState<DeadPerson | undefined>(undefined);

    const params = useParams();
    const id: string | undefined = params.id;

    useEffect(() => {
        if (id) {
            getDeadPerson(id)
                .then((response) => setDeadPerson(response.data))
                .catch((error) => console.log(error));
        }
    }, [id]);

    if (!deadPerson) {
        return <div>Loading...</div>
    }

    return (
        <div>
            <h1>Details</h1>
            <div>
                <p>Dead Person:</p>
                <p>Id: {deadPerson.id}</p>
                <p>First Name: {deadPerson.firstName}</p>
                <p>Last Name: {deadPerson.lastName}</p>
                <p>Date of Birth: {deadPerson.dateOfBirth}</p>
                <p>Date of Death: {deadPerson.dateOfDeath}</p>
                <p>Place of Birth: {deadPerson.placeOfBirth}</p>
                <p>Place of Death: {deadPerson.placeOfDeath}</p>
            </div>
            <hr/>
            <div>
                <p>Address:</p>
                <p>Street: {deadPerson.street}</p>
                <p>House Number: {deadPerson.houseNumber}</p>
                <p>Zip Code: {deadPerson.zipCode}</p>
                <p>City: {deadPerson.city}</p>
                <p>Country: {deadPerson.country}</p>
            </div>
        </div>
    );
}
