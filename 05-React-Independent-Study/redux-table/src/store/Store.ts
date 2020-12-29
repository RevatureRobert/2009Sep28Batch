import { AnyAction, CombinedState, combineReducers, createStore, Reducer, Store } from "redux";
import { IRecordsState, recordReducer } from "./reducers/RecordsReducer";

/**
 * 2ND STEP
 * 
 * COMBINE REDUCERS
 */

// This type should have a property for each reducer/state pair in the application.
// For instance, if there was a NumberState of type INumState, this would be a property, as commented out below.
export interface IRootState{
    RecordsState:IRecordsState,
    //NumberState:INumState
}


// This next part actually combines the reducers.
// The type of the "rootState" variable doesn't matter much for our applications;
//      we can just not declare its type (by just calling it rootState without any ":type" suffix)

// What really matters is that we put the "IRootState" generic argument in "combineReducers<IRootState>"
const combinedReducer:Reducer<CombinedState<IRootState>, AnyAction> = combineReducers<IRootState>(
    {
        RecordsState: recordReducer
    }
)



/*********************
 * 3RD STEP
 * 
 * CREATE THE STORE
 */

// Simplest implementation.
// You may add a second argument as a store enhancer (especially useful for debugging),
//      but the only thing that's absolutely necessary is the combined reducer.
 export const store:Store<IRootState> = createStore(combinedReducer);