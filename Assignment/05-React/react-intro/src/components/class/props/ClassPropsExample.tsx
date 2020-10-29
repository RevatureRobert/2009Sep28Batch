import React from 'react';

interface IProps{
    value:string;
    name: string;

}

/**
 * This is our example of props. To create a react component, we need to use the
 * constructor that takes in props and call super(props) to properly create our component.
 * Props is short for properties. 
 * 
 * inside render(): using {} binds those values to the inner text of that element. 
 */
export class ClassPropsExample extends React.Component<IProps, any>{
    constructor(props:any){
        super(props);
    }

    render(){
        return (
            <div>
                <p>{this.props.value}</p>
                <p>{this.props.name}</p>
            </div>
        )
    }
}