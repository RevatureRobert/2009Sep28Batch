import React, { useState } from 'react';
import './App.css';
import { PizzaPieTable } from './components/PizzaPie/PizzaPieTable';
import { PizzaPie } from './models/PizzaPie';
import { getAllPizzas } from './util/remote';

function App() {
  const [pizzas, setPizzas] = useState<PizzaPie[]>([]); // arg is initial state
  const setPizzasFromFetch = async () => {
    const pizzas = await getAllPizzas();
    setPizzas(pizzas);
  }

  return (
    <div className="App">
      <PizzaPieTable pizzas={pizzas}/>
      <button onClick={setPizzasFromFetch}>get pizzas</button>
    </div>
  );
}

export default App;
