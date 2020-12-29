import React from 'react';
import logo from './logo.svg';
import './App.css';
import {useSelector, useDispatch} from 'react-redux';
import {increment} from './actions/increment';
import {decrement} from './actions/decrement';
import { StateType } from './reducers';

function App() {
  const counter = useSelector((state:StateType) => state.counter);
  const isLogged = useSelector((state:StateType) => state.isLogged);
  const dispatch = useDispatch();

  return (
    <div className="App">
      <h1>Counter: {counter}</h1>
      <button onClick={() => dispatch(increment())}>+</button>
      <button onClick={() => dispatch(decrement())}>-</button>

      {isLogged ? <h3>Info I shouldn't see unless logged in</h3> : ''}
    </div>
  );
}

export default App;
