//This is how we actually build the store
//You should never really have to change this file.

import { compose, createStore, Store } from "redux";
import { state } from "./reducers";

const a: any = window;

// if there are devtools installed, let them be used
//    otherwise use the default ones from redux.
const composeEnhancers =
  (window as any).__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const enhancer = composeEnhancers();

export const store: Store<any> = createStore(state, enhancer);
