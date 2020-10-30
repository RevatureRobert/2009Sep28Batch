import React from 'react';

/**
 * This was an example of a component taking in props for
 * the react-router example
 */

interface IProps{
    vals: string[]
}

export const AnyList:React.FC<IProps> = (props:IProps) => {
    return(
        <ul>
            {
                props.vals.map( (elem, identity) => <li key={identity}>{elem}</li>)
            }
        </ul>
    )
}