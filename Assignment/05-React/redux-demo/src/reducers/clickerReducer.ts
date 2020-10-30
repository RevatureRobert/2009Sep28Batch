import { ClickerTypes } from "../action-mappers/clicker-action";

const initialState = {
  numOfClicks: 0,
};

export const clickerReducer = (state = initialState, action: any) => {
  switch (action.type) {
    case ClickerTypes.CLICKED:
      return {
        ...state,
        numOfClicks: state.numOfClicks + action.payload.numOfClicks,
      };
    default:
      return state;
  }
};
