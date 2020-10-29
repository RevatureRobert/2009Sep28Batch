import React from 'react';
import { ClassClicker } from './components/class/clicker/ClassClicker';
import { ClassLifecycleExample } from './components/class/lifecycle/ClassLifecycleExample';
import { ClassPropsExample } from './components/class/props/ClassPropsExample';
import { ClassStateExample } from './components/class/state/ClassStateExample';
import { FunctionClicker } from './components/function/clicker/FunctionClicker';
import { Hooks } from './components/function/hooks/Hooks';
import { FunctionPropsExample } from './components/function/props/FunctionPropsExample';

//two styles of components in react: Classes and Functions

/**
 * This is the starting point of your development, here we will add in
 * the components for the application. we start by importing
 * React, and extend the Componenent class in React and give the generics
 * for it. The generics are for state and props that will be covered later.
 * 
 * the render function must be overriden, this tells React what to render
 * to the virtual dom. It can only return one element, everything else
 * must be nested inside that element. 
 */
class App extends React.Component<any, any> {
  render() {
    return (
      <div>
        <p>Enoch</p>
        {/* You can either have a closing tag or a self closing tag. 
      make this self closing if there is no content in between tags. */}
        <ClassClicker />
        <FunctionClicker />
        <ClassPropsExample name="hero" value="zero" />
        <FunctionPropsExample name="new hero" value="new zero" />
        <ClassStateExample name="class state name" />
        <ClassLifecycleExample />
        <Hooks/>
      </div>
    );
  }
}

export default App;