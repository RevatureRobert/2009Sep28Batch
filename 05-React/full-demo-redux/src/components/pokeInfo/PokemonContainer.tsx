import React from 'react';
import { connect } from 'react-redux';
import { addPokemon } from '../../action-mappers/pokemon-action';
import { IState } from '../../reducers';
import { PokeInfo } from './PokeInfo';

/**
 * 
 * @param state 
 * This container maps the redux state and reducers to the
 * props of the pokeInfo component
 */
const mapStateToProps = (state:IState) => {
    return{
        pokes:state.pokeState.pokes
    };
}

const mapDispatchToProps = {
    getPokemon:addPokemon
}

// currying; returns a function that takes in the parameter PokeInfo
export default connect(mapStateToProps, mapDispatchToProps)(PokeInfo);