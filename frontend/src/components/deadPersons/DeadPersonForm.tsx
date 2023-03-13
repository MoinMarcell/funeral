import {DeadPerson} from "../../models/DeadPerson";
import {ChangeEvent, FormEvent, useEffect, useState} from "react";

type DeadPersonFormProps = {
    handleDeadPerson: (deadPerson: DeadPerson) => void;
    deadPerson?: DeadPerson;
}

export const DeadPersonForm = (props: DeadPersonFormProps) => {

    const emptyDeadPerson: DeadPerson = {
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        dateOfDeath: '',
        placeOfBirth: '',
        placeOfDeath: '',
        street: '',
        houseNumber: '',
        zipCode: '',
        city: '',
        country: ''
    }

    const [deadPerson, setDeadPerson] = useState<DeadPerson>(emptyDeadPerson);

    useEffect(() => {
        if (props.deadPerson) {
            setDeadPerson(props.deadPerson);
        }
    }, [props.deadPerson]);

    const handleChangeDeadPerson = (event: ChangeEvent<HTMLInputElement>) => {
        setDeadPerson({
            ...deadPerson,
            [event.target.name]: event.target.value
        })
    }

    const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        props.handleDeadPerson(deadPerson);
        setDeadPerson(emptyDeadPerson);
    }

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="firstName">
                First Name
                <input type="text" name="firstName" id="firstName" value={deadPerson.firstName}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="lastName">
                Last Name
                <input type="text" name="lastName" id="lastName" value={deadPerson.lastName}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="dateOfBirth">
                Date of Birth
                <input type="date" name="dateOfBirth" id="dateOfBirth" value={deadPerson.dateOfBirth}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="dateOfDeath">
                Date of Death
                <input type="date" name="dateOfDeath" id="dateOfDeath" value={deadPerson.dateOfDeath}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="placeOfBirth">
                Place of Birth
                <input type="text" name="placeOfBirth" id="placeOfBirth" value={deadPerson.placeOfBirth}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="placeOfDeath">
                Place of Death
                <input type="text" name="placeOfDeath" id="placeOfDeath" value={deadPerson.placeOfDeath}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="street">
                Street
                <input type="text" name="street" id="street" value={deadPerson.street}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="houseNumber">
                House Number
                <input type="text" name="houseNumber" id="houseNumber" value={deadPerson.houseNumber}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="zipCode">
                Zip Code
                <input type="text" name="zipCode" id="zipCode" value={deadPerson.zipCode}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="city">
                City
                <input type="text" name="city" id="city" value={deadPerson.city}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <label htmlFor="country">
                Country
                <input type="text" name="country" id="country" value={deadPerson.country}
                       onChange={handleChangeDeadPerson}/>
            </label>
            <button type="submit">Create</button>
        </form>
    );

}