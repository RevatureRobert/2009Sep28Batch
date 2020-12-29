import { connect } from "react-redux";
import { DataEntry } from "../components/DataEntry";
import { IRecord } from "../store/reducers/RecordsReducer";

export interface IEntryAdder{
    addEntry:(isNecessity:boolean, details:string, amount:number, when:number) => {type:string, payload:IRecord}
}

const mapDispatchToProps:IEntryAdder = {
    // THE "addEntry" FUNCTION IS YOUR ACTION; YOU TYPICALLY DEFINE THIS IN ANOTHER FILE AND USE ITS NAME INSTEAD OF DEFINING IT HERE.
    // YOU WANT TO DEFINE IT IN ITS OWN FILE IF YOU'RE GOING TO USE IT IN MORE THAN ONE PLACE.
    addEntry:(isNecessity:boolean, details:string, amount:number, when:number) => {
        
        return {
            type: "ADD_RECORD",
            payload:{
                necessity: isNecessity,
                description: details,
                price: amount,
                byWhatYear: when
            }
        }
    }
};

// There are no state variables to map, so the first argument can just be null.
export default connect(null, mapDispatchToProps)(DataEntry);