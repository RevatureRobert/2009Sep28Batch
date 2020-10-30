import React from "react";
import { Form } from "reactstrap";
import { IPunkin } from "./IPunkin";

/**
 * This component is meant to take information and create a
 * Punkin object. We take in the function to do so as props
 * to pass the values back up to the parent component. Remember,
 * data can only flow downward.
 */

interface IProps {
  punkinGetter: (p: IPunkin) => void;
}

export const PunkinCreator: React.FC<IProps> = (props: IProps) => {
  const newPunkin: IPunkin = {
    name: "",
    description: "",
    size: 0,
    pretty: false,
  };

  const create = (event: React.SyntheticEvent<HTMLFormElement>) => {
    newPunkin.name = event.currentTarget["pName"].value;
    newPunkin.description = event.currentTarget["pDescription"].value;
    newPunkin.size = event.currentTarget["pSize"].value;
    newPunkin.pretty = event.currentTarget["pPretty"].checked;
    console.log(newPunkin);
    props.punkinGetter(newPunkin);
    event.preventDefault();
  };

  return (
    <Form onSubmit={create}>
      <input type="text" name="pName" />
      <input type="text" name="pDescription" />
      <input type="number" name="pSize" id="" />
      <input type="checkbox" name="pPretty" />
      <input type="submit" value="create" />
    </Form>
  );
};
