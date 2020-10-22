call(); //hoisting is where a function will be brought to the
//top of its scope and can be ran before being declared
//realistically, this is the two stage memory bringing
//the function in and creating it before the
//initialization/invocation phase

//functions
//  notice no return type
function sum(a, b) {
  return a + b;
}

function retUndef() {
  return undefined;
}

function nothing() {}

const sumVar = sum(1, 2),
  u = retUndef(),
  some = nothing();

console.log(sumVar, u, some);

//declare functions
//function syntax
function one() {}

//variable declaration syntax
const two = function two() {};

//anonymous functions
const three = function () {};

//arrow functions
const four = () => {};

//functions are first class citizens
const five = console.log;

//callback
const six = function (callback) {
  callback("some value");
};

//callback example
function call() {
  console.log("this is a callback");
}
setTimeout(call, 3000);
setTimeout(() => console.log("fgsiuhu"), 1000);

//operators
/* 
  typeof    returns the string representation of the data type of the operand
  ==        equality with type coercian
  ===       equality without type coercian
  +x        convert into number
  isNaN     returns a boolean if the operand if the operand is not a number
*/

//truthy and falsey

//falsey values: 0, false, NaN, "", null, undefined
//truthy values: anything that is not falsey
function isItTruthy(value) {
  if (value) {
    console.log(true);
  } else {
    console.log(false);
  }
}

//anonymous functions
//IIFE - Immediately Invokable function expression
const a = (function () {
  return 7;
})();

//closure
const driveCar = (function () {
  console.log("the car has been purchased");
  let miles = 0;
  return function (mile) {
    console.log("the car has been driven " + mile + "miles");
    miles += mile;
    console.log("the current mileage is " + miles);
    return miles;
  };
})();