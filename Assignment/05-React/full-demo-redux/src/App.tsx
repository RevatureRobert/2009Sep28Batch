import React from "react";
import { RouterProps } from "react-router";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import { AnyList } from "./components/anyTable/AnyList";
import { Home } from "./components/home/Home";
import { DemoNavBar } from "./components/nav/DemoNavBar";
import { PokeInfo } from "./components/pokeInfo/PokeInfo";
import { PunkinTable } from "./components/PunkinTable/PunkinTable";
import { Login } from "./login/login";

const App: React.FC<any> = () => {
  return (
    <BrowserRouter
      basename="/" //determines the route beginnings.
      //If you are hosting on a server in a subdirectory this would be that.
    >
      <DemoNavBar />
      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/punkin" /*component = {PunkinTable}*/ render={() => localStorage.getItem('username')?<PunkinTable/>:<Home/>}/>
        <Route path="/list" render={(props: RouterProps) => <AnyList vals = {['first','second','third']}/>}/>
        <Route path ="/login" component ={Login} />
        <Route path ="/pokes" component ={PokeInfo} />
      </Switch>
    </BrowserRouter>
  );
};

export default App;
