// import { Popcorn } from "./Popcorn";    //named import
// import { Popcorn as Corn} from './Popcorn'; //alias import
import corn from "./Popcorn"; //default import (give it any name)

const kelseyPopcorn = new corn(null, null, null, null);

kelseyPopcorn.toppings.strange.push(["hot sauce", 3.4]);
kelseyPopcorn.toppings.cheese.push(["parmesan", 4.2]);
kelseyPopcorn.butterAmount = 2;
kelseyPopcorn.salty = false;
kelseyPopcorn.isBurnt = false;
console.log(kelseyPopcorn);
console.log(JSON.stringify(kelseyPopcorn));
