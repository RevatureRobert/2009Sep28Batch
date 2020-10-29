import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { Home } from "./component/home/Home";
import { DemoNavBar } from "./component/nav/DemoNavBar";

const App: React.FC<any> = () => {
  return (
    <BrowserRouter basename="/">
      <DemoNavBar />
      <Switch>
        <Route path="/" component={Home} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
