import React, { useEffect } from "react";

/**
 * With class components, we can utilize the lifecycle hooks
 * and initialize the state in the constructor. Prior to React
 * 16, functions could not handle their own state.
 */
export const Hooks: React.FC<any> = () => {
  /**
   * useState is a React hook that enables us to create
   * state inside a functional component.
   *
   * We destructure the useState returned values to get
   * the reference to the value of the state property and the
   * setter to set the state value.
   *
   * useState takes in the initial value as an argument
   * and uses a generic type. If you do not give it a
   * generic type, it will infer it from the initial value.
   */
  const [num, setNum] = React.useState<number>(0);

  /**
   * In place of the various lifecycle methods we have in class
   * components, in functional components we have the useEffect
   * hook. This function takes a callback function and will
   * invoke it whenever the component updates.
   */
  useEffect(() => {
    console.log("the effect hook is being ran");
  });

  /**
   * This deals with the context api, perfect for alot of things,
   * not perfect for all things. Essentially a way the you can create
   * application wide properties.
   */
  // React.useContext(putContextHere);

  return (
    <div>
      <button onClick={() => setNum(num + 1)}>{num}</button>
    </div>
  );
};
