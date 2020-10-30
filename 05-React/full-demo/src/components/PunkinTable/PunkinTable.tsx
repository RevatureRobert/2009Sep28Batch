import React, { useState } from "react";
import { Table } from "reactstrap";
import { IPunkin } from "./IPunkin";
import { PunkinCreator } from "./PunkinCreator";
import { PunkinRow } from "./PunkinRow";

interface IProps {}

export const PunkinTable: React.FC<IProps> = (props: IProps) => {
  const [punkins, setPunkins] = useState<IPunkin[]>([]);

  const addPunkin = (p: IPunkin) => {
    setPunkins([...punkins, p]);
  };
  return (
    <div>
      <Table>
        <thead>
          <tr>
            <th>Name</th>
            <th>description</th>
            <th>size</th>
            <th>Pretty</th>
          </tr>
        </thead>
        <tbody>
          {punkins.map((p, i) => (
            <PunkinRow key={i} punkin={p} />
          ))}
        </tbody>
      </Table>
      <PunkinCreator punkinGetter={addPunkin} />
    </div>
  );
};
