import { connect } from "react-redux";
import { incrementClicks } from "../action-mappers/clicker-action";
import { IState } from "../reducers";
import { ClickerComponent } from "./ClickerComponent";

const mapStateToProps = (state: IState) => {
  return {
    numOfClicks: state.ClickerState.numOfClicks,
  };
};

const mapDispatchToProps = {
  clickHandler: incrementClicks,
};

export default connect(mapStateToProps, mapDispatchToProps)(ClickerComponent);
