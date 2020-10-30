import React, { SyntheticEvent } from 'react';

interface IProps{
    name:string;
}
interface IState{
    name:string;
    value:string;
}

/**
 * The state of a componend is the immutable and persistend information
 * vital to the component's functionality. It differs from props because
 * props are meant to be maintained by a parent component and passed
 * down as properties of the child component. Props can provide value to a
 * component's state vut stat is mean to be maintained by the component
 * itself.
 * 
 * A component's state is IMMUTABLE;
 *      instead, the React API will be used for managing the state.
 * 
 * Notice the creation of the state in the constructor. The State
 * needs to be initialized with all the properties before the
 * component is mounted during its creation.
 * 
 * By setting this.state({...}), you initialize the state
 * of the component. By using this.setState({...}), you can
 * update and manage the state. Remember, the state is immutable.
 */
export class ClassStateExample extends React.Component<IProps, IState>{


    constructor(props:IProps){
        super(props);
        this.state={
            name:props.name,
            value:''
        };
    }

    handleChange(event:React.SyntheticEvent<HTMLInputElement>):void{
        this.setState({
            ...this.state,
            value:event.currentTarget.value
        });
    }

    render():JSX.Element{
        return(
            <div>
                <p>{this.state.name}</p>
                <p>{this.state.value}</p>
                <input
                    type='text'
                    value={this.state.value}
                    onChange={(e) => this.handleChange(e)}
                />
            </div>
        );
    }
}