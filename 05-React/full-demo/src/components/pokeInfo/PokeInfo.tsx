import React, { SyntheticEvent, useState } from 'react';
import { Form, Input, Table } from 'reactstrap';
import { axiosInstance } from '../../util/axiosConfig';

/**
 * This component will utilize axios to retrieve pokemon
 * information from an api. It holds a form to get new information,
 * a table to display it, and a pokemon array in its state to maintain
 * the component.
 */

interface IProps{}

export const PokeInfo:React.FC<IProps> = (props:IProps) => {
    
    const [pokes, setPokes] = useState<
        {id:number, name:string, type:string, sprite:string}[]
    >([
        //{id:1, name:'bulbasaur', type:'grass', sprite:''},
    ]);

    const addPoke = async (eve:SyntheticEvent<HTMLFormElement>) => {
        const pid = +eve.currentTarget['pId'].value; // REMINDER: the + unary operator casts to number
        // const {id, name, type} =
        const response = await axiosInstance.get('' + pid);
        console.log(response);
        // eve.preventDefault();
        const {id, name} = response.data;
        const type = response.data.types[0].name
        const sprite = response.data.sprites.front_default;
        setPokes([
            ...pokes,
            {
                id, name, type, sprite,
            }
        ])
    }
    
    return(
        <div>
            <Table>
                <thead>
                    <tr>
                        <th>number</th>
                        <th>name</th>
                        <th>type</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        pokes.map( (elem, identity) => (
                            <tr key={identity}>
                                    <td>{elem.id}</td>
                                    <td>{elem.name}</td>
                                    <td>{elem.type}</td>
                                    <td>
                                        <img src={elem.sprite} />
                                    </td>
                                </tr>
                            )
                        )
                    }
                </tbody>
            </Table>
            <Form onSubmit={addPoke}>
                <Input type='number' name='pId' />
                <Input type='submit' name="get that poke/who's that pokemon???" />
            </Form>
        </div>
    )
}