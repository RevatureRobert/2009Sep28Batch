

/*
we need to import Popcorn class, but first we need to export from Popcorn.ts
imports from the javascript file.

*/

import {Popcorn} from "./Popcorn";
const kelseyPopcorn = new Popcorn();

kelseyPopcorn.toppings.strange.push(['hot sauce',3.4]);
kelseyPopcorn.toppings.cheese.push(['parmesean',4.2]);
kelseyPopcorn.butterAmount = 2;
kelseyPopcorn.salty = false;
kelseyPopcorn.isBurnt = false;
console.log(kelseyPopcorn);
console.log(JSON.stringify(kelseyPopcorn));