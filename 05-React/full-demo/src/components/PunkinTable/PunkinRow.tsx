import React, { Fragment } from "react";
import { IPunkin } from "./IPunkin";

/**
 * This component takes in a Punkin object and renders
 * a table row with it. Take note of the fragment syntax.
 * This can be used when a component is being used as
 * an integral part of another component. Such as lists'
 * li's and tables' tr's, we can use fragments to provide
 * a root tag for the component we are trying to make, as
 * opposed to creating a new div or other.
 */

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
