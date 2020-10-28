import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import { Home } from "./components/home/Home";
import { DemoNavBar } from "./components/nav/DemoNavBar";
import { PunkinTable } from "./components/PunkinTable/PunkinTable";

const App: React.FC<any> = () => {
  return (
    <BrowserRouter
      basename="/" //determines the route beginnings.
      //If you are hosting on a server in a subdirectory this would be that.
    >
      <DemoNavBar />
      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/punkin" component={PunkinTable} />
      </Switch>
    </BrowserRouter>
  );
};

export default App;
