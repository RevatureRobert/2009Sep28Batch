import React from 'react';
import './App.css';
import { Provider } from 'react-redux';
import { store } from './store/Store';
import TableContentsContainer from './containers/TableContentsContainer';
import DataEntryContainer from './containers/DataEntryContainer';


/**
 * PERSONAL PROJECT FOR REFERENCING:
 *    REACT REDUX WITH TYPESCRIPT
 *      MOST VARIABLE TYPES ARE EXPLICIT AND VERBOSE
 * 
 * 
 * I recommend reading the logic in this order:
 * 
 * STEP 1: './store/reducers/RecordsReducer.ts'
 *        -- make an initial state/reducer pair
 * 
 * STEP 2: './store/Store.ts'
 *        -- combine the reducers and create the store with that combined reducer
 * 
 * STEP 3: THIS FILE (look below these comments)
 *        -- wrap the app in a Provider tag, and replace all React components with container components
 * 
 * STEP 4a: './containers/TableContentsContainer.ts'
 *        -- take properties from the store and pass them into TableContents as props
 * 
 * STEP 5a: './components/TableContents.tsx'
 *        -- render table contents from props, as if the props were passed in normally
 * 
 * STEP 4b: './containers/DataEntryContainer.ts'
 *        -- create a function that returns an object with action functions in it, then pass that into DataEntry as props
 * 
 * STEP 5b: './components/DataEntry.tsx'
 *        -- render DataEntry contents from props, as if the action function was passed in as a property of a normal props variable
 * 
 * 
 * 
 * EXTRA NOTE: Only files that have JSX (the pseudo-HTML tags) need to have ".tsx" extensions;
 *              any other file can just have a ".ts" extension.
 * 
 * EXTRA NOTE 2: For the 2-argument connect and createStore functions,
 *              see Robert's redux-demo project under his 'ClickerContainer.tsx' and 'Store.ts' files, respectively.
 * 
 * @author NICOLAS HERNANDEZ, NOV-5-2020
 * 
 * This is a working Redux version of the React TypeScript responsive-table component assigned on October 30th, 2020.
 */
function App() {
  return (
    <div className="App">
      <Provider store={store}>

      <table>
        <caption>Wish List</caption>
        <thead>
          <tr>
            <th>Necessity? |</th>
            <th>Description |</th>
            <th>Price |</th>
            <th>By What Year? |</th>
          </tr>
        </thead>
        <TableContentsContainer />
      </table>
      <DataEntryContainer />
      </Provider>
    </div>
  );
}
// There are only two differences between this and a normal React app:
// 1.) The "Provider" tag, which must wrap around the entire application for it to access the store.
// 2.) The "Container" tags, which are wrappers around any of the actual components you want;
//    "TableContentsContainer" actually renders a "TableContents" component.
// The "Container" tags exist solely to pass in actions and state variables as props.

export default App;
