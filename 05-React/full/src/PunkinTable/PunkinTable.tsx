import React, { useState } from 'react';
import { PunkinCreator } from './PunkinCreator';
import { PunkinRow } from './PunkinRow';

interface IProps{}

interface IPunkin{
    name: string;
    description: string;
    size:number;
    pretty:boolean;
}

export const PunkinTable:React.FC<IProps> = (props:IProps) => {
    const [punkins, setPunkins] = useState<IPunkin[]>([]);

    const addPunkin = (p:IPunkin) => {
        setPunkins([...punkins, p]);
    }

    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Size</th>
                        <th>Pretty?</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        punkins.map( (p, i) => <PunkinRow key={i} punkin={p} />)
                    }
                </tbody>
            </table>

            <PunkinCreator punkinGetter={addPunkin} />
        </div>
    );
}