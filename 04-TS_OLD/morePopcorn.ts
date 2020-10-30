//import {Popcorn} from "./Popcorn"; // named import
//import {Popcorn as Corn} from './Popcorn'; // alias import
import Popcorn from './Popcorn'; // default import

const oddcorn = new Popcorn(null, null, null, null);

// oddcorn.toppings.strange.push(['hot sauce', 3.4], ['horse radish', 0.2]); // this array is uninitialized, so you can't push to it!

oddcorn.toppings.strange.push(['hot sauce', 3.4], ['horse radish', 0.2]); // can push to it now!
oddcorn.toppings.cheese = [['parmesan', 4.2]];
oddcorn.butterAmount = 2;
oddcorn.salty = false;
oddcorn.isBurnt = false;
console.log(oddcorn);
console.log(JSON.stringify(oddcorn));



const username = 'summat';
const obj = {
    popcorn: {
        oddcorn,
        pop: "yes",
        username,
        name: username
    }
}