

/*
we need to import Popcorn class, but first we need to export from Popcorn.ts
imports from the javascript file.

*/

// import {Popcorn} from "./Popcorn";  //named import
//import {Popcorn as Corn} from "./Popcorn"; //you can set alias for Popcorn
import Corn from './Popcorn'; //default import, you can name the Popcorn class whatever you want, automatic alias

const kelseyPopcorn = new Corn(null, null, null, null);

kelseyPopcorn.toppings.strange.push(['hot sauce',3.4]);
kelseyPopcorn.toppings.cheese.push(['parmesean',4.2]);
kelseyPopcorn.butterAmount = 2;
kelseyPopcorn.salty = false;
kelseyPopcorn.isBurnt = false;
console.log(kelseyPopcorn);
console.log(JSON.stringify(kelseyPopcorn));