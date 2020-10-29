import React from 'react';

/**
 * with class components, we can utilize the lifecycle hooks
 * and initialize the state in the constructor. Prior to React 16, 
 * functions could not handle their own state, so they were called dumb components. 
 */
export const Hooks: React.FC<any> = () => {
    /**
     * useState is a React hook that enables us to create
     * state inside a funcitonal component.
     * 
     * we destructure the useState returned values to get
     * the reference to the value of the state property and the setter
     * to set the state value.
     * 
     * useState takes in the inital value as an argument and uses a generic type.
     * If you do not give it a generic type, it will infer it from the initial value.
     */
    const [num, setNum] = React.useState(0);

    /**
     * in place of the various lifecylce methods we have in class components, 
     * in functional components we have the useEffect hook.
     * This functino takes a callback function. 
     */

    React.useEffect(() =>{
        console.log("the effect hook is being ran");
    });


    /**
     * htis deals with the context api, perfect a lot of things,
     * not perfect for all things. Essentially a way to create application wide properties
     */
    //React.useContext(putContextHere);
    return(
        <div>
            <button onClick={()=>setNum(num+1)}>{num}</button>
        </div>
    )
}