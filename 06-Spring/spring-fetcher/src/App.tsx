import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { PizzaPieTable } from './components/PizzaPie/PizzaPieTable';
import { PizzaPie } from './models/PizzaPie';
import { getAllPizzas } from './util/remote';

function App() {
  const [pizzas, setPizzas] = useState<PizzaPie[]>([]);

  const setPizzasFromfetch = async () => {
    const pizzas = await getAllPizzas();
    setPizzas(pizzas);
  }
  return (
    <div className="App">
      <PizzaPieTable pizzas={pizzas}/>
      <button onClick={setPizzasFromfetch}>get pizzas</button>
    </div>
  );
}

export default App;
