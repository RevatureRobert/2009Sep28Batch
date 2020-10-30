import { Popcorn } from "./Popcorn";

const kelseyPopcorn = new Popcorn();

kelseyPopcorn.toppings.strange.push(["hot sauce", 3.4]);
kelseyPopcorn.toppings.cheese.push(["parmesan", 4.2]);
kelseyPopcorn.butterAmount = 2;
kelseyPopcorn.salty = false;
kelseyPopcorn.isBurnt = false;
console.log(JSON.stringify(kelseyPopcorn));
