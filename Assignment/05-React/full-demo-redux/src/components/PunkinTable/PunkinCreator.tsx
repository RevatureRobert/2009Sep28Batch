import React from "react";
import { Form } from "reactstrap";
import { IPunkin } from "./IPunkin";

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
    newPunkin.name = event.currentTarget['pName'].value;
    newPunkin.description = event.currentTarget['pDescription'].value;
    newPunkin.size = event.currentTarget['pSize'].value;
    newPunkin.pretty = event.currentTarget['ppretty'].checked;
    console.log(newPunkin);

    event.preventDefault();
    console.log(newPunkin);
    props.punkinGetter(newPunkin);
    event.preventDefault();
  };

  return (
    <Form onSubmit={create}>
      <input type="text" name="pName" />
      <input type="text" name="pDescription" />
      <input type="number" name="pSize"/>
      <input type="checkbox" name="ppretty" />
      <input type="submit" value="create" />
    </Form>
  );
};