import React from 'react';
import { Route, Switch } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import { Home } from './components/home/Home';
import { DemoNavBar } from './components/nav/DemoNavBar';
import { PunkinTable } from './PunkinTable/PunkinTable';

// RE: basics on running it
//NPM package manager
//NPX script runner
// npm run start
//    npm start
// npm run test


/**
 * reactrouter.com has react-router* libraries' documentation
 */
export const App:React.FC<any> = () => {
  return(
    <div>
      <BrowserRouter
        basename='/' // Determines the route beginnings.
        // If you are hosting on a server in a subdirectory, this would be that subdirectory.
        >
        <DemoNavBar/>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route path='/punkin' copmonent={PunkinTable} />
        </Switch>
        <p>hello to the full demo</p>
      </BrowserRouter>
    </div>
  )
}

export default App;