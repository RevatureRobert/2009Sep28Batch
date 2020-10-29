import React from "react";
import { Spinner } from "reactstrap";

interface IProps {}

export const Home: React.FC<IProps> = (props: IProps) => {
  return (
    <div>
      <Spinner color="success" />
    </div>
  );
};