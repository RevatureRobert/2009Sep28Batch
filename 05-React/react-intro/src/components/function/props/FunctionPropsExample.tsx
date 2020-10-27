import React from "react";

interface IProps {
  name: string;
  value: string;
}

/**
 *
 * @param props are the properties for the component. These are attributes for
 * the component that will be treated as arguments for the function. Data in
 * React always flows from top to bottom, from parent to child.
 *
 *
 */
export const FunctionPropsExample: React.FC<IProps> = (props: IProps) => {
  return (
    <div>
      <p>{props.name}</p>
      <p>{props.value}</p>
    </div>
  );
};
