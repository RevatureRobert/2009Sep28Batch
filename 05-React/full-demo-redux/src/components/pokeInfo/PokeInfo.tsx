import React, { SyntheticEvent, useState } from "react";
import { Form, Input, Table } from "reactstrap";
import { axiosInstance } from "../../util/axiosConfig";
import { Pokemon } from "./Pokemon";

/**
 * This component will utilize axios to retrieve pokemon
 * information from an api. It holds a form to get new information,
 * a table to display it, and a pokemon array in its state to maintain
 * the component.
 */
interface IProps {
  pokes: Pokemon[];
  addPokemon: (id: number) => void;
}

export const PokeInfo: React.FC<IProps> = (props: IProps) => {
  const addPoke = async (eve: SyntheticEvent<HTMLFormElement>) => {
    eve.preventDefault();
    props.addPokemon(+eve?.currentTarget["pId"].value);
  };

  return (
    <div>
      <Table>
        <thead>
          <tr>
            <th>number</th>
            <th>name</th>
            <th>type</th>
            <th>image</th>
          </tr>
        </thead>
        <tbody>
          {props.pokes.map((e, i) => (
            <tr key={i}>
              <td>{e.id}</td>
              <td>{e.name}</td>
              <td>{e.type}</td>
              <td>
                <img src={e.sprite} alt="none available" />
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Form onSubmit={addPoke}>
        <Input type="number" name="pId" />
        <Input type="submit" value="get that poke/whats that pokemon?!?" />
      </Form>
    </div>
  );
};
