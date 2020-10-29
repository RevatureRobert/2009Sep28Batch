import React from 'react';

interface IProps {
    name: string;
}

interface IState {
    name: string;
    value: string;
}
/**
 * The state of a component is the immutable and persistent information vital to the components
 * functionality. IT differs from props because props are meant to be maintained by a parent component
 *  and passed down as properties of the child component. Props can provide value to a components state
 * but state is meant to be maintained by the component itself. 
 * 
 * number 1 rule about a state of a component
 * 1. It's immutable! React API will manage the state, not us. 
 * 
 * Notice the creation of the state in the constructor. The state needs to be initialized
 * with all properties before the component is mounted during its creation. 
 * 
 * By setting this.state({...}), you initialize the state of the component. 
 * By using this.setState({...}) you can update and manage the state. Remember, the state is immutable. 
 */
export class ClassStateExample extends React.Component<IProps, IState>{

    constructor(props: IProps) {
        super(props);
        this.state = {
            name: props.name,
            value: ''
        }
    }

    handleChange(event: React.SyntheticEvent<HTMLInputElement>): void {
        this.setState({
            ...this.state,
            value: event.currentTarget.value
        })
    }

    render() {
        return (
            <div>
                <p>{this.state.name}</p>
                <p>{this.state.value}</p>
                <input type="text" value={this.state.value} onChange={e => this.handleChange(e)} />
            </div>
        )
    }

}