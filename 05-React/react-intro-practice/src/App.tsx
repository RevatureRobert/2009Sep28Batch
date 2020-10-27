import React from 'react';
import { ClassClicker } from './components/class/clicker/ClassClicker';
import {FunctionClicker} from "./components/function/FunctionClicker";

class App extends React.Component<any, any> {
  render() {
    return (
      <div>
        <p>2009</p>
        <ClassClicker/>
      </div>
    )
  }
}

export default App;