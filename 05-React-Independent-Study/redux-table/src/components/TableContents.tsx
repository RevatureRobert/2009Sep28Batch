import React from 'react';
import { IRecordsState } from '../store/reducers/RecordsReducer';


/**
 * This function operates as if it was passed in props normally.
 * 
 * @param props 
 */
export const TableContents:React.FC<IRecordsState> = (props:IRecordsState) => {    
    return(
        <tbody>
            {
                props.records.map(
                    (element, index) => 
                    <tr key={index}>
                            <td>{element.necessity ? "YES" : "NO"}</td>
                            <td>{element.description}</td>
                            <td>${element.price}</td>
                            <td>{element.byWhatYear}</td>
                        </tr>
                )
            }
        </tbody>
    );
}
/**
 * NOTE:
 * You won't always have a type like IRecordsState readily available for passing in as your prop type.
 * The actual prop type will ALWAYS be a combination of your "mapStateToProps" return type and your "mapDispatchToProps" object type.
 * For instance, if your mapStateToProps returns "{num: 7}" and your mapDispatchToProps is "{str: 'hello'}", then your prop typs will be {num:number, str:string}
 *
 * Since there wasn't a mapDispatchToProps passed in, the type is the same as the object returned from mapStateToProps; a type IRecordsState.
 */