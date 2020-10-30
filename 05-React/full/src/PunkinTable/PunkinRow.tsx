import React from 'react';
import { IPunkin } from './IPunkin';

interface IProps{
    punkin: IPunkin;
}

export const PunkinRow:React.FC<IProps> = (props:IProps) => {
    return(
        <> {/* React.Fragment type */}
            <tr>
                <td>{props.punkin.name}</td>
                <td>{props.punkin.description}</td>
                <td>{props.punkin.size}</td>
                <td>{props.punkin.pretty + ""}</td>
            </tr>
        </>
    );
}