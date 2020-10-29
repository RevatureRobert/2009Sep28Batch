import React, { SyntheticEvent } from 'react';
import { Form, Input } from 'reactstrap';


interface IProps{

}

export const Login:React.FC<IProps> = (props:IProps) =>{
    const handleSubmit = (eve: SyntheticEvent<HTMLFormElement>) =>{
        localStorage.setItem('username', eve.currentTarget['username'].value);
        eve.preventDefault();
    }
    
    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Input type = "text" name = 'username'/>
                <Input type ="submit" value="submit here"/>
            </Form>
        </div>
    )
}