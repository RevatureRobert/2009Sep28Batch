import React from 'react';
import counterReducer from './counter';
import loggedReducer from './isLogged';
import {combineReducers} from 'redux';

export const allReducers = combineReducers(
    {
        counter: counterReducer,
        isLogged: loggedReducer
    }
)

export type StateType = ReturnType<typeof allReducers>;