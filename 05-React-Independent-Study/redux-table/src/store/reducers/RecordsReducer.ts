
/**
 * STORE CREATION
 * 
 * STEP 1
 * 
 * CREATE REDUCERS
 * 
 * THIS STEP NEEDS TO BE REPEATED FOR EVERY REDUCER,
 * THOUGH IT DOES NOT ALWAYS NEED TO BE AS VERBOSE.
 * 
 * ALL THE TYPES ARE EXPLICITLY DEFINED IN ORDER TO MAKE THIS MORE USABLE AS A REFERENCE.
 * 
 * IN THIS IMPLEMENTATION, EACH REDUCER WILL BE PAIRED WITH AN INITIAL STATE.
 */

 // This is the type of record that will be added to the records array.
export interface IRecord{
    necessity:boolean,
    description:string,
    price:number,
    byWhatYear:number
}

// This is the state type that holds the records array.
// If IRecord wasn't defined above, it would have to be defined as the type of object being held in the array,
//      demonstrated here:
//      records:{necessity:boolean, description:string, price:number, byWhatYear:number}[]
export interface IRecordsState{
    records:IRecord[]
}

// This is the actual initial state;
// Notice that the empty records array is initialized "[] as IRecord[]"
//      If something is just "[]", then TypeScript may infer it as a type "Never[]"
const initialState:IRecordsState = {
    records:[] as IRecord[]
}

// Actual reducer.
//  Takes in a type IRecordState and a type of action object that has a string "type" property and an IRecord "payload" property
//  STAY AWARE OF THIS TYPE NOTATION FOR OBJECTS WITH PROPERTIES; YOU CANNOT DEFINE THE TYPE AS A SIMPLE OBJECT IF YOU WANT TO ACCESS ITS PROPERTIES
export const recordReducer = (state:IRecordsState = initialState, action:{type:string, payload:IRecord}) => {
    switch(action.type){
        case "ADD_RECORD":
            return {
                records:[
                    ...state.records,// clones ever record in state.records
                    action.payload// appends a new record; only works because "action.payload" is of type "IRecord" in the function parameters
                ]
            };
        default:
            return state;
    }
}