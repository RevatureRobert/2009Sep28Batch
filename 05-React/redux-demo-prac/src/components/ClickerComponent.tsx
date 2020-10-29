import React from "react";
import "./ClickerComponent.css";

interface IProps {
  numOfClicks: number;
  clickHandler: (num: number) => void;
}

export const ClickerComponent: React.FC<IProps> = (props: IProps) => {
  return (
    <button className="color-red" onClick={() => props.clickHandler(1)}>
      {props.numOfClicks}
    </button>
  );
};
