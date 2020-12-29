import React from 'react';

interface ITableProps{
    records:{
        necessity:boolean,
        description:string,
        price:number,
        byWhatYear:number
    }[]
}

interface IState{
    records:{
        necessity:boolean,
        description:string,
        price:number,
        byWhatYear:number
    }[]
}

export class TableContents extends React.Component<ITableProps, IState>{
    constructor(props:ITableProps){
        super(props);

console.log("TableContents initialized!")

        this.state = {
            ...this.props
        }
    }
    
    render(){
        console.log("Render in TableContents!");

        return(
            <tbody>
                {
                    this.props.records.map(
                        (element, index) => 
                            <tr key={index}>
                                <td>{element.necessity ? "YES" : "NO"}</td>
                                <td>{element.description}</td>
                                <td>{element.price}</td>
                                <td>{element.byWhatYear}</td>
                            </tr>
                    )
                }
            </tbody>
        );
    }
}