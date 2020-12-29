import React from 'react';
import { IEntryAdder } from '../containers/DataEntryContainer';

/**
 * This function operates as if props were passed into it normally.
 * 
 * @param props 
 */
export const DataEntry:React.FC<IEntryAdder> = (props:IEntryAdder) => {
    
    // React.useState() is still used here because not every component on the entire site needs to know every change that happens to every form element;
    //      only THIS component needs to know what's in these particular form elements.
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
            
            <button onClick={(e) => { e.preventDefault(); return props.addEntry(necessity, description, price, year); }}>Add wish!</button>
        </form>
    );
}
/**
 * See the note at the bottom of the "TableContents" file.
 * 
 * A similar principle applies here. 
 */