import React from "react";
import { RouterProps } from "react-router";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import { AnyList } from "./components/anyTable/AnyList";
import { Home } from "./components/home/Home";
import { Login } from "./components/login/Login";
import { DemoNavBar } from "./components/nav/DemoNavBar";
import { PokeInfo } from "./components/pokeInfo/PokeInfo";
import { PunkinTable } from "./components/PunkinTable/PunkinTable";
/**
 * This is the routes that are available for the application.
 *
 * we use switch so it matches the routes and does not render everything
 * underneath it.
 *
 * we have routes,
 *
 *    the first is the / path, notice the exact path
 *      for the route, this makes it to where there is
 *      no conflict in other routes and the url has to
 *      match the path exactly.
 *
 *    the list route uses the render callback to generate
 *      the component with props.
 *
 *    the punkin route uses the render callback to check the
 *      condition of something before the component is rendered.
 *      This is know as conditional rendering.
 * 
 * 
 * 
 * May take out dev dependencies by casting "rm -Recurse -Force .\node_modules\" in the "\full-demo\ directory"
 * 
 * cd full-demo
 * rm -Rf node_modules/
 * cd ..
 * cp -R full-demo/ full-demo-redux/
 * ls
 * cd full-demo
 * npm i
 * 
 */

const App: React.FC<any> = () => {
  return (
    <BrowserRouter
      basename="/" //determines the route beginnings.
      //If you are hosting on a server in a subdirectory this would be that.
    >
      <DemoNavBar />
      <Switch>
        <Route exact path="/" component={Home} />
        <Route
          path="/punkin" /*component={PunkinTable}*/
          render={() =>
            //localStorage.getIteam("username") ? <PunkinTable /> : <Home />
            localStorage.getItem("username") && <PunkinTable />
          }
        />
        <Route
          path="/list"
          render={(props:RouterProps) => (
            <AnyList vals={['first', 'second', 'third']} />
          )}
        />
        <Route path='/login' component={Login} />
        <Route path='pokes' component={PokeInfo} />
      </Switch>
    </BrowserRouter>
  );
};

export default App;
