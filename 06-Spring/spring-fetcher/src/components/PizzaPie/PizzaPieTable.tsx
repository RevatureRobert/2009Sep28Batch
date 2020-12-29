import React from 'react';
import { PizzaPie } from '../../models/PizzaPie';

interface IProps{
    pizzas:PizzaPie[]
}

export const PizzaPieTable:React.FC<IProps> = (props:IProps) => {
    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>toppings</th>
                        <th>crust</th>
                        <th>diameter</th>
                        <th>stuffed</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        props.pizzas.map((element, index) => (
                                <tr key={index}>
                                    <td>
                                        <ul>
                                            {
                                                element.toppings.map((elem, indx) => (
                                                        <li key={indx}>
                                                            {elem}
                                                        </li>
                                                    )
                                                )
                                            }
                                        </ul>
                                    </td>
                                    <td>{element.crust}</td>
                                    <td>{element.diameter}</td>
                                    <td>{element.toppings}</td>
                                </tr>
                            )
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}