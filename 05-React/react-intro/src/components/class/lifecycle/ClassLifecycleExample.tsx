import React from 'react';



export class ClassLifecycleExample extends React.Component<any, {num:number}>{

    /**
     * 
     * @param props 
     * 
     * The constructor is called to instatiate the component
     * and create the properties necessary to render it
     * to the DOM.
     * 
     * Note: you must call super with props in React to
     * enable it to be rendered to the DOM.
     */
    constructor(props:any){
        super(props);
        console.log('this is the constructor');
        this.state={
            num:0
        };
    }

    /**
     * This method is called to render the component to the DOM,
     * or to re-render it.
     */
    render(){
        return(
            <div>
                <button onClick={()=>this.setState({ num: this.state.num + 1})}>
                    {this.state.num}
                </button>
            </div>
        )
    }

    /**
     * This method is called when there is a change to the props
     * or state and determines if the render() function should
     * be called again.
     */
    shouldComponentUpdate(){
        console.log("in the shouldComponentUpdate function");
        return true;
    }

    /**
     * this function is called when the component is being re-rendered
     */
    componentDidUpdate(){
        console.log('component did update');
    }

    /**
     * This function is called when a component is being removed
     * from the DOM.
     */
    componentWillUnmount(){
        console.log('component will unmount');
    }

    /**
     * This method is called when there is an error during rendering, in a
     * lifecycle method, or in the constructor of any child component.
     */
    componentDidCatch(){
        console.log('component did catch');
    }
}