import React from 'react';

interface IProps{
    vals:string[];
}

export const AnyList: React.FC<IProps> = (props: IProps) => {
    return (
      <ul>
          {
              props.vals.map((e,i) => <li key = {i}>{e}</li>)
          }
      </ul>
    )
} 