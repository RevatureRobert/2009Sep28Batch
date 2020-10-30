import { IState } from "../../reducers";
import { getPokemon } from "../../action-mappers/pokemon-action";
import { connect } from "react-redux";
import { PokeInfo } from "./PokeInfo";

/**
 *
 * @param state
 * This container maps the redux state and reducers to the
 * props of the pokeInfo component.
 */
const mapStateToProps = (state: IState) => {
  return {
    pokes: state.pokeState.pokes,
  };
};

const mapDispatchToProps = {
  getPokemon: getPokemon,
};

//currying
export default connect(mapStateToProps, mapDispatchToProps)(PokeInfo);
