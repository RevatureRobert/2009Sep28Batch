import { combineReducers } from "redux";
import { Pokemon } from "../components/pokeInfo/Pokemon";
import { IPunkin } from "../components/PunkinTable/IPunkin";
import { pokemonReducer } from "./PokemonReducer";

export interface IPokesState {
  pokes: Pokemon[];
}

export interface IPunkinTableState {
  punkins: IPunkin[];
}

export interface IState {
  pokeState: IPokesState;
  // punkinState: IPunkinTableState;
}

export const state = combineReducers<IState>({
  pokeState: pokemonReducer,
});
