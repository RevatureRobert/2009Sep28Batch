import React from 'react';
import { DataEntry } from './DataEntry';
import { TableContents } from './TableContents';

interface IRecord{
    necessity:boolean,
    description:string,
    price:number,
    byWhatYear:number
  }

export class TableContainer extends React.Component<any, any> {
    constructor(props:any){
        super(props);

        this.state = {
            records:[] as IRecord[]
                /*
                {
                    necessity:true,
                    description:"FOOD, SHELTER, AND LOVE",
                    price:4000000,
                    byWhatYear: 2025
                }
            ]
               */
        }
    }
  
    addEntry = (isNecessity:boolean, details:string, amount:number, when:number) => {
        const newRecord:IRecord = {
            necessity: isNecessity,
            description: details,
            price: amount,
            byWhatYear: when
        };
        
        console.log(newRecord.necessity);

        this.setState({
            records:[
                ...this.state.records,
                newRecord
            ]
        });
    }

    render(){
        return(
            <>
                <table>
                    <thead>
                    <tr>
                        <th>Necessity?</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>By What Year?</th>
                    </tr>
                    </thead>
                    <TableContents records={this.state.records}/>
                </table>

                <DataEntry recordAdder={this.addEntry}/>
            </>
        )
    }
}