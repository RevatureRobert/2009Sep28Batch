import React from "react";

interface IProps {
  numOfClicks: number;
  clickHandler: (num: number) => void;
}

export const ClickerComponent: React.FC<IProps> = (props: IProps) => {
  return (
    <button onClick={() => props.clickHandler(1)}>{props.numOfClicks}</button>
  );
};
