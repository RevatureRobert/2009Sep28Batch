import React from 'react';

interface IProps{
    value:string;
    name:string;
}

/**
 * This is out example of props. To create a React component, we need
 * to use the constructor that takes in props and call super(props) to
 * properly create our component.
 */
export class ClassPropsExample extends React.Component<IProps, any>{

    /*constructor(props:IProps){
        super(props);
    }*/ // This particular constructor is already the default one

    render(){
        return(
            <div>
                <p>{this.props.value}</p>
                <p>{this.props.name}</p>
            </div>
        );
    }
};