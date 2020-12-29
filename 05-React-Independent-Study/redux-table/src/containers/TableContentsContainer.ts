import { connect } from "react-redux";
import { TableContents } from "../components/TableContents";
import { IRecordsState } from "../store/reducers/RecordsReducer";
import { IRootState } from "../store/Store";

// The function's type is (s:IRootState) => IRecordsState;
//      It's explicitly defined here ONLY FOR DEMONSTRATION PURPOSES
const mapStateToProps:(s:IRootState) => IRecordsState =
    (state:IRootState) => {
        return {
            records: state.RecordsState.records
        }
}

// There are no actions to map, so the second "connect()" argument may be omitted.
export default connect(mapStateToProps)(TableContents);