import React, { Component } from 'react';

interface IProps{

}

interface IState{
    wishes:{
        priority:number;
        description:string;
        price:number;
        byWhatYear:number;
    }[]
}

class TableRows extends Component {
    state:IState;
    
    constructor(props:IProps) {
       super(props);
       this.state = {
          wishes: [
             { priority: 1, description: 'Some rest', price: 4000000, byWhatYear: 2021 },
             { priority: 2, description: 'Porpoise', price: 300000, byWhatYear: 2022 },
             { priority: 3, description: 'Home theater', price: 4000, byWhatYear: 2020 },
             { priority: 4, description: 'FOOD, SHELTER, AND LOVE', price: Infinity, byWhatYear: 2025 },
          ]
       };
    }

    renderTableData() {
        return this.state.wishes.map((wish, index) => {
           const { priority, description, price, byWhatYear } = wish
           return (
              <tr key={priority}>
                 <td>{priority}</td>
                 <td>{description}</td>
                 <td>{price}</td>
                 <td>{byWhatYear}</td>
              </tr>
           )
        })
     }
  
     render() {
        return (
           <div>
              <h1 id='title'>Wish list</h1>
              <table id='wishes'>
              <thead>
                    <th>Priority</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>By when?</th>
                </thead>
                 <tbody>
                    {this.renderTableData()}
                 </tbody>
              </table>
           </div>
        )
     }
 }

export default TableRows;