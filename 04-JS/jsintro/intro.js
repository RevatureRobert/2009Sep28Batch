//single line comment
/* multi line comment */
console.log("this is how you print inside js");
call(); //hoisting is where a function will be brought to the
//top of its scope and can be ran before being declared
//realistically, this is the two stage memory bringing
//the function in and creating it before the
//initialization/invocation phase

/* 
  js is interpreted, never compiled
    made in 1995 by netscape for the explorer browser
    js is mainly used for making pages dynamic, however
      with the birth of nodejs we have seen an explosion 
      in full stack js.
    
  js has data types
    number, boolean, string, object, null, undefined, symbol, function
  how we declare variables
    var, let, const
      var is left for historical reasons and backwards compatibility
        do not use it
      let is the new var
      const declares a constant
*/
//    js is loosely typed, you can assign any type to any variable at any time
// let s = "string";
// s = 7;
// s=true;

const bool = true;
const str = "string"; //single or double quotes for strings
const sym = Symbol();
const obj = { name: "james" };
const num = 8;
const fun = function () {};
const nul = null;
const und = undefined;
let undef; //this is undefined by js

//objects

//object literal notation
const o = {
  name: "james",
  age: 6,
  stepsTaken: 0,
  walk: function (steps) {
    this.stepsTaken += steps;
  },
};

//using a constructor
const date = new Date();
date.hammer = 8;
console.log(date.hammer);

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

//scopes
// const val = true;                           //global
// let val = true;                             //global
var val = true; //global
function check() {
  // const maybe = "something";                //function
  // let maybe = 'something';                  //function
  var maybe = "something"; //function
  if (val) {
    // const panic = "aaaaaaaaaaahhhhhhhh"; //block
    // let panic = "aaaaahhh"; //block
    var panic = "aaaaahhhhh"; //function
    // panic = "something"; //very bad practice...global scope
  }
  // console.log(panic);
}

const arr = ["alligator", 9, false, undefined, null, Symbol(), NaN];

//traditional for loop
// for (let i = 0; i < arr.length; i++) {
//   console.log(arr[i]);
// }

//for of loop grabs the element
// for (let i of arr) {
//   console.log(i);
// }

//for in loop grabs the index
// for (let i in arr) {
//   console.log(i);
// }

// classes

// pre-2015 class
function Person(name, age) {
  this.age = age;
  this.name = name;
  this.yell = function () {
    console.log(this.name.toUpperCase() + "!!!!!!!!");
  };
}

//post-2015 class
class Person2 {
  constructor(name, age) {
    this._name = name;
    this._age = age;
  }
  yell() {
    console.log(this.name.toUpperCase());
  }

  get name() {
    return this._name;
  }
  set name(name) {
    this._name = name;
  }

  get age() {
    return this._age;
  }

  set age(age) {
    // this._age = age;
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
  return [
    function (mile) {
      console.log("the car has been driven " + mile + "miles");
      miles += mile;
      console.log("the current mileage is " + miles);
      return miles;
    },
    function () {
      return 5;
    },
  ];
})();
