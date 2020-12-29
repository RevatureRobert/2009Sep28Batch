import React from 'react';

interface IProp{
    recordAdder:(necessity:boolean, desc:string, cost:number, when:number) => void
}

export const DataEntry:React.FC<IProp> = (props:IProp) => {
    const [necessity, setNecessity] = React.useState(false);
    const [description, setDescription] = React.useState("");
    const [price, setPrice] = React.useState(0);
    const [year, setYear] = React.useState(2020);

    return(
        <form>
            <label>Is necessity? </label>
            <input type="checkbox" checked={necessity} onChange={() => setNecessity(!necessity)} />
            
            <label>Description: </label>
            <input type="text" value={description} onChange={(changeEvent) => setDescription(changeEvent.target.value)} />
            
            <label>Price:</label>
            <input type="number" min="0" step="0.01" value={price} onChange={(changeEvent) => setPrice(Number.parseFloat(changeEvent.target.value))} />
            
            <label>By what year?</label>
            <input type="number" min="2020" step="1" value={year} onChange={(changeEvent) => setYear(Number.parseFloat(changeEvent.target.value))} />
            
            <button onClick={(e) => { e.preventDefault(); return props.recordAdder(necessity, description, price, year); }}>Add wish!</button>
        </form>
    );
}