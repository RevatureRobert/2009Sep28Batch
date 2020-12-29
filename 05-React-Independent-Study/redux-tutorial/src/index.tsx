import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {createStore} from 'redux';
import {allReducers} from './reducers';
import { Provider } from 'react-redux';

const store = createStore(allReducers);

/**
 * STORE
 *  globalized state
 *  is an object that takes reducer into its constructor
 * 
 * ACTION
 *  describes what you want to do
 *  is a function that returns an object
 * 
 * REDUCER
 *  defines how actions transform this state into the next state
 *  is a function that takes the initial state and the action return;
 *    reducer = (state, whateverActionReturns)
 * 
 * DISPATCH
 *  "dispatch this action to the reducer"
 *  is a store method; store.dispatch(action())
 */

/*
import {createStore} from 'redux';

// This is the action.
const increment = () => {
  return {
    type: 'INCREMENT'
  };
}
const decrement = () => {
  return {
    type: 'DECREMENT'
  };
}

// This is the reducer.
const counter:any = (state:number = 0, action: { type:string; }) => {
  switch(action.type){
    case "INCREMENT":
      return state + 1;
    case "DECREMENT":
      return state - 1;
  }
}
    
// This is the store.
const store:any = createStore(counter);

// Display store in the console every time the store is updated...
store.subscribe(() => console.log(store.getState()));

// This is the dispatch
store.dispatch(increment());
store.dispatch(decrement());
store.dispatch(decrement());
*/

/* ------------------------------------------- */
    

ReactDOM.render(
    <React.StrictMode>
      <Provider store={store}>
        <App />
      </Provider>

    </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
