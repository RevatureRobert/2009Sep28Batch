import React from "react";

/**
 *
 * This is the first class component. Here we extend the React Component class
 * and override the render function. We return what is known as tsx (jsx). it
 * is typescript (javascript) with xml like syntax.
 */
export class ClassClicker extends React.Component<any, any> {
  render() {
    return (
      <div>
        <button>this clicks, yay!!!</button>
      </div>
    );
  }
}
