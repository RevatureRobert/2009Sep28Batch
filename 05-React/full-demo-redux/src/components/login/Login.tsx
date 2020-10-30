import React, { SyntheticEvent } from 'react';
import { Form, Input } from 'reactstrap';

/**
 * Extremely simple login just takes in input and puts it
 * in localStorage.
 */
interface IProps{

}

export const Login:React.FC<IProps> = (props:IProps) => {
    const handleSubmit = (eve:SyntheticEvent<HTMLFormElement>) => {
        localStorage.setItem('username', eve.currentTarget['username'].value);
        eve.preventDefault();

    }
    
    return(
        <Form>
            <Input type='text' name='username' />
            <Input type='submit' name='submit here' />
        </Form>
    )
}