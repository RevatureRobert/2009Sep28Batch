import React from 'react'; // ALWAYS start a tsx file with this.
import { ClassClicker } from './components/class/clicker/ClassClicker';
import { ClassLifecycleExample } from './components/class/lifecycle/ClassLifecycleExample';
import { ClassPropsExample } from './components/class/props/ClassPropsExample';
import { ClassStateExample } from './components/class/state/ClassStateExample';
import { FunctionClicker } from './components/function/clicker/FunctionClicker';
import { Hooks } from './components/function/hooks/Hooks';
import { MyComponent } from './components/function/mycomp/MyComponent';
import { FunctionPropsExample } from './components/function/props/FunctionPropsExample';

// Components can be made as classes AND functions...

/**
 * This is the starting point of tsx development, here we will
 * add in the components for the application. We start by importing
 * React, extending the Component class in React and giving the generics
 * for it. The generics are for state and props that we will go over later.
 * 
 * the render function must by overridden, this tells React what to render
 * to the virtual dom.
 */
class App extends React.Component<any, any> {
  render():JSX.Element{
    const [a, b, ...c] = [1, 2, 3, 4];
    const [d, e, f] = [...c, b, 5, 6];

    console.log('A: ' + a);
    console.log('B: ' + b);
    console.log('C: ' + c);
    console.log('D: ' + d);
    console.log('E: ' + e);
    console.log('F: ' + f);
    return(
      <div> {/* Special syntax for commenting inside the tsx content */}
        <p>2009</p>
        <ClassClicker />
        <FunctionClicker />
        <MyComponent />
        <ClassPropsExample name='hero' value='x man' />
        <FunctionPropsExample name='new hero' value='mister incredulous' />
        <ClassStateExample name="class state name" />
        <ClassLifecycleExample />
        <Hooks />
      </div>
    );
  }
}

export default App; // This is exported to the ReactDOM.render() in index.tsx