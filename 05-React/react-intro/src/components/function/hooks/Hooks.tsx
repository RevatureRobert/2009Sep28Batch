import React, { useEffect } from 'react';

/**
 * with class components, we can utilize the lifecycle hooks
 * and initialize the state in the constructor.
 * 
 * Prior to React 16, FUNCTIONS could not handle their own state.
 */

export const Hooks:React.FC<any> = () => {
    //  let num = 0;

    /**
     * useState is a React hook that enables us to create
     * state inside a functional component.
     * 
     * We destructure the useState returned values to get
     * the reference to the value of the state property
     * and the setter to set the state value.
     * 
     * @param num is the value of the state
     * @param setNum is the setter for num, takes in the
     *  intial value as an argument and uses a generic type.
     *  If you do not give it a generic type, it will infer it
     *  from the intial value;
     */
    const [num, setNum] = React.useState(0);

    /**
     * In place of the various lifecycle methods we have in class components,
     * in functional components, we have the useEffect hook. The function takes
     * a callback function and will invoke it whenever the component updates.
     */
    React.useEffect(() => {
            console.log('the effect hook is being run');
        }
    );

    /**
     * This deals with the Context API, perfect for a lot of things,
     * not perfect for all things. Essentially a way that you can create
     * application-wide properties.
     */
    // React.useContext(putContextHere);

     return(
         <div>
             <button onClick={() => setNum(num+1)}>{num}</button>
         </div>
     )
}