import React from "react";
import { Spinner } from "reactstrap";

/**
 *
 * Home is a sample homepage for the app, it just has a
 * reactstrap spinner for simplicity.
 */

interface IProps {}

export const Home: React.FC<IProps> = (props: IProps) => {
  return (
    <div>
      <Spinner color="success" />
    </div>
  );
};
