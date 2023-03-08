import axios from "axios";

const BASE_URI: string = "/api/dead-persons";

export async function getAllDeadPersons() {
    return await axios.get(BASE_URI);
}