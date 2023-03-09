import axios from "axios";
import {DeadPerson} from "../models/DeadPerson";

const BASE_URI: string = "/api/dead-persons";

export async function getAllDeadPersons() {
    return await axios.get(BASE_URI);
}

export async function createDeadPerson(deadPerson: DeadPerson) {
    return await axios.post(BASE_URI, deadPerson);
}

export async function getDeadPerson(id: string) {
    return await axios.get(BASE_URI + "/" + id);
}
