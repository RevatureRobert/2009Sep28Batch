import React, { Fragment } from "react";
import { IPunkin } from "./IPunkin";

interface IProps {
  punkin: IPunkin;
}

export const PunkinRow: React.FC<IProps> = (props: IProps) => {
  return (
    <>
      <tr>
        <td>{props.punkin.name}</td>
        <td>{props.punkin.description}</td>
        <td>{props.punkin.size}</td>
        <td>{props.punkin.pretty + ""}</td>
      </tr>
    </>
  );
};
