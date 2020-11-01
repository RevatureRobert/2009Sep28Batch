import React from "react";
import "./AnyTable.css";
/**
 * This was an example of a component taking in props for
 * the react-router example
 */
interface IProps {
  vals: string[];
}
export const AnyList: React.FC<IProps> = (props: IProps) => {
  return (
    <ul>
      {props.vals.map((e, i) => (
        <li className="color-red" key={i}>
          {e}
        </li>
      ))}
    </ul>
  );
};
