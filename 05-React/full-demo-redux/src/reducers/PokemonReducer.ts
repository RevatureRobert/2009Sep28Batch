import { IPokesState } from ".";
import { pokemonTypes } from "../action-mappers/pokemon-action";

const initialState: IPokesState = {
  pokes: [],
};

export const pokemonReducer = (
  state = initialState,
  action: any
): IPokesState => {
  switch (action.type) {
    case pokemonTypes.SUCCESSFUL_POKEMON_ADDITION:
      return {
        pokes: [...state.pokes, action.payload],
      };
    case pokemonTypes.UNSUCCESSFUL_POKEMON_ADDITION:
      return state;
    default:
      return state;
  }
};
