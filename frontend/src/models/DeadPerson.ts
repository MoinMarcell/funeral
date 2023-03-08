import {Address} from "./Address";

export type DeadPerson = {
    id?: string;
    firstName: string;
    lastName: string;
    dateOfBirth: string;
    dateOfDeath: string;
    placeOfBirth: string;
    placeOfDeath: string;
    address: Address;
}