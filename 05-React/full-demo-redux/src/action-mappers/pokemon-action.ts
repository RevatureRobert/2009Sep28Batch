import { Pokemon } from "../components/pokeInfo/Pokemon";
import { axiosInstance } from "../util/axiosConfig";

export const pokemonTypes = {
  SUCCESSFUL_POKEMON_ADDITION: "POKEMON_SUCCESSFULLY_ADDED",
  UNSUCCESSFUL_POKEMON_ADDITION: "POKEMON_UNSUCCESSFULLY_ADDED",
};

export const getPokemon = (id: number) => async (dispatch: any) => {
  if (id > 893 || id < 1) {
    dispatch({
      type: pokemonTypes.UNSUCCESSFUL_POKEMON_ADDITION,
    });
  }
  const response = await axiosInstance.get("" + id);
  const poke: Pokemon = {
    id: response.data.id,
    name: response.data.name,
    type: response.data.types[0].type.name,
    sprite: response.data.sprites.front_default,
  };

  dispatch({
    type: pokemonTypes.SUCCESSFUL_POKEMON_ADDITION,
    payload: {
      poke,
    },
  });
};
