import {useNavigate, useParams} from "react-router-dom";
import useDeadPerson from "../../hooks/useDeadPerson";

type DeadPersonDetailsPageProps = {
    deleteDeadPersonById: (id: string) => void,
}

export default function DeadPersonDetailsPage(props: DeadPersonDetailsPageProps) {

    const navigate = useNavigate();

    const params = useParams();
    const id: string | undefined = params.id

    const {deadPerson, loading} = useDeadPerson(id ? id : '');

    if (loading) return <p>Loading...</p>

    if (!deadPerson) return <p>Dead Person not found</p>

    function handleEditClick() {
        if (deadPerson) navigate("/dead-persons/edit/" + deadPerson.id);
    }

    function handleDeleteClick() {
        if (id) {
            props.deleteDeadPersonById(id);
            navigate("/dead-persons");
        }
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
            <button onClick={handleEditClick}>Edit</button>
            <button onClick={handleDeleteClick}>Delete</button>
        </div>
    );
}
