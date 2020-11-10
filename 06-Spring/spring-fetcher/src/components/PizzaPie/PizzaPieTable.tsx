import React from "react";
import { PizzaPie } from "../../models/PizzaPie";

interface IProps{
    pizzas:PizzaPie[];
}
export const PizzaPieTable: React.FC<IProps> = (props:IProps) => {
  return (
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
                props.pizzas.map((e, i) => (
                    <tr key={i}>
                        <td>
                            <ul>
                            {
                                e.toppings?
                                e.toppings.map((el,ind)=>(
                                    <li key={ind}>
                                        {el}
                                    </li>
                                )):
                                <li>no toppings</li>
                            }
                            </ul>
                        </td>
                    <td>{e.crust}</td>
                    <td>{e.diameter}</td>
                    <td>{e.stuffed}</td>
                </tr>
                ))
            }
          </tbody>
      </table>
    </div>
  );
};
