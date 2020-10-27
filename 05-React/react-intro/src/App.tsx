import React from "react";
import { ClassClicker } from "./components/class/clicker/ClassClicker";
import { ClassLifecycleExample } from "./components/class/lifecycle/ClassLifecycleExample";
import { ClassPropsExample } from "./components/class/props/ClassPropsExample";
import { ClassStateExample } from "./components/class/state/ClassStateExample";
import { FunctionClicker } from "./components/function/clicker/FunctionClicker";
import { FunctionPropsExample } from "./components/function/props/FunctionPropsExample";
/**
 * This is the starting point of your development, here we will
 * add in the components for the application. We start by importing
 * React, extending the Component class in React and giving the generics
 * for it. The generics are for state and props that we will go over later.
 *
 * the render function must be overridden, this tells React what to render
 * to the virtual dom.
 */
class App extends React.Component<any, any> {
  render() {
    return (
      <div>
        <p>2009</p>
        <ClassClicker />
        <FunctionClicker />
        <ClassPropsExample name="hero" value="zero" />
        <FunctionPropsExample name="new hero" value="new zero" />
        <ClassStateExample name="class state name" />
        <ClassLifecycleExample />
      </div>
    );
  }
}

export default App;
