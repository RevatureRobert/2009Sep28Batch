// This is how we actually build the store
// You will build this once and never touch it again for your application

import { applyMiddleware, compose, createStore, Store } from "redux";
import { state } from "./reducers";
import reduxThunk from "redux-thunk";

const a:any = window;

// If there are devtools installed, let them be used.
//  Otherwise, use the default ones from redux.
const composeEnhancers = a.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const enhancer = composeEnhancers(applyMiddleware(reduxThunk));

export const store:Store<any> = createStore(state, enhancer);