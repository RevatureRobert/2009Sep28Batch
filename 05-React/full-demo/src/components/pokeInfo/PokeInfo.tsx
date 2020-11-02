import React, { SyntheticEvent, useState } from "react";
import { Form, Input, Table } from "reactstrap";
import { axiosInstance } from "../../util/axiosConfig";

/**
 * This component will utilize axios to retrieve pokemon
 * information from an api. It holds a form to get new information,
 * a table to display it, and a pokemon array in its state to maintain
 * the component.
 */
interface IProps {}

export const PokeInfo: React.FC<IProps> = (props: IProps) => {
  const [pokes, setPokes] = useState<
    { id: number; name: string; type: string; sprite: string }[]
  >([]);

  const addPoke = async (eve: SyntheticEvent<HTMLFormElement>) => {
    eve.preventDefault();
    const pid = +eve.currentTarget["pId"].value;
    // const {id, name, type} =
    const response = await axiosInstance.get("" + pid);
    console.log(response.data);
    const { id, name } = response.data;
    const type = response.data.types[0].type.name;
    const sprite = response.data.sprites.front_default;
    setPokes([
      ...pokes,
      {
        id,
        name,
        type,
        sprite,
      },
    ]);
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
          {pokes.map((e, i) => (
            <tr key={i}>
              <td>{e.id}</td>
              <td>{e.name}</td>
              <td>{e.type}</td>
              <td>
                <img src={e.sprite} />
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
