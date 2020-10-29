import Axios from "axios";

export const axiosInstance = Axios.create({
    baseURL:"https://pokeapi.co/api/v2/pokemon/"
});


