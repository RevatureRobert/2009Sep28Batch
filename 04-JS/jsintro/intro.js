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
  return function (mile) {
    console.log("the car has been driven " + mile + "miles");
    miles += mile;
    console.log("the current mileage is " + miles);
    return miles;
  };
})();

const stringy =
  "this is a string, if we want to add in variables such as " +
  arr +
  "we " +
  "need to concatenate it in the string. if we want to create a line break, we need to " +
  "either add in the escape character \\ or we have to concatenate.";

const betterStringy = `or we can use backticks and it will allow us to go to different
lines without having to concatenate and if we want to throw in variables, we can use \${}
syntax and add them in such as ${arr} we can also perform js code inside the template
literal such as ${driveCar()} ${console.log("hairy baby")}`;

// oop concepts in js
//inheritance
//polymorphism
//abstraction
//encapsulation
//inheritance: prototype inheritance (the skeleton of the object) (classes are sugar syntax for
//                                        prototype inheritance)
//polymorphism: overriding
//abstraction: modules
//encapsulation: modules, closure

// working with prototypes
// > const obj = {name:'bob'}
// undefined
// > obj
// { name: 'bob' }
// > obj.toString()
// '[object Object]'
// > obj.toString=function(){console.log('this is bob')}
// [Function]
// > obj.toString=function(){return 'this is bob'}
// [Function]
// > obj.toString()
// 'this is bob'
// > obj.__proto__.toString()
// '[object Object]'
// > obj.__proto__.toString=function(){return 'hey its the proto'}
// [Function]
// > obj.toString()
// 'this is bob'
// > obj.__proto__.toString()
// 'hey its the proto'
// > const obj2={name:'susan'}
// undefined
// > obj2.toString()
// 'hey its the proto'

//obj3=obj
// undefined
// > obj3.toString()
// 'this is bob'
// > obj3.toString=()=>'obj3'
// [Function]
// > obj3.toString()
// 'obj3'
// > obj.toString()
// 'obj3'
// > const obj4 = {}
// undefined
// > obj4.__proto__=obj
// { name: 'bob', toString: [Function] }
// > obj
// { name: 'bob', toString: [Function] }
// > obj.toString()
// 'obj3'
// > obj4
// {}
// > obj4.__proto__
// { name: 'bob', toString: [Function] }
// > obj4.toString()
// 'obj3'
// > obj4.toString=()=>'no more numbers'
// [Function]
// > obj4.toString()
// 'no more numbers'
// > obj4.__proto__.toString()
// 'obj3'
// > obj4
// { toString: [Function] }
// > const obj5 = Object.create(obj)
// undefined
// > obj5
// {}
// > obj5.__proto__
// { name: 'bob', toString: [Function] }

// operators
//    short circuiting
//      default operator
/* 
true || true
true
true || false
true
true || 0
true
false || 0
0
'' || 'go home kid'
"go home kid"
function hey(){
    console.log('this has ran');
    
    return true;
}
undefined
true || hey()
true
11 || hey()
11
0 || hey()
VM541:2 this has ran
true
undefined || 0
0
undefined || 0 || ''
""
undefined || 1 || ''
1
*/

//    guard operator
/* 
true && false
false
true && 0
0
true && 11
11
false && 11
false
0 && 11
0
false && hey()
false
2 && hey()
VM541:2 this has ran
true
Boolean(0||7)
true
!!(0||11)
true
*/

//array methods
/* 
const arr = ['alligator','kangaroo',11,undefined, 77]
undefined
arr
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter((element) => {
    return typeof element === 'string';
})
(2) ["alligator", "kangaroo"]
arr
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter(e=>typeof e === 'string')
(2) ["alligator", "kangaroo"]
arr.filter(e=>true)
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter(e=>false)
[]
arr.filter(e=>elide)
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter(e=>e)
(4) ["alligator", "kangaroo", 11, 77]
arr.forEach(e=>console.log(e))
VM2475:1 alligator
VM2475:1 kangaroo
VM2475:1 11
VM2475:1 undefined
VM2475:1 77
undefined
arr.forEach(console.log)
VM2558:1 alligator 0 (5) ["alligator", "kangaroo", 11, undefined, 77]0: "alligator"1: "kangaroo"2: 113: undefined4: 77length: 5__proto__: Array(0)
VM2558:1 kangaroo 1 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2558:1 11 2 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2558:1 undefined 3 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2558:1 77 4 (5) ["alligator", "kangaroo", 11, undefined, 77]
undefined
arr.forEach((element, index, array) => console.log(element, index, array))
VM2789:1 alligator 0 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 kangaroo 1 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 11 2 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 undefined 3 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 77 4 (5) ["alligator", "kangaroo", 11, undefined, 77]
undefined
arr.filter
ƒ filter() { [native code] }
arr.filter((e,i,a,b,v,c)=>console.log(e,i,a,b,v,c))
VM3089:1 alligator 0 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 kangaroo 1 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 11 2 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 undefined 3 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 77 4 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
[]
arr.map(e=>+e)
(5) [NaN, NaN, 11, NaN, 77]
arr.map(e=>console.log())
(5) [undefined, undefined, undefined, undefined, undefined]
arr.map(e=>console.log(e))
VM3360:1 alligator
VM3360:1 kangaroo
VM3360:1 11
VM3360:1 undefined
VM3360:1 77
(5) [undefined, undefined, undefined, undefined, undefined]
*/

//function parameters and operator on them
function sum(a, b, c, d, e, f) {
  return a + b + c + d + e + f;
}

// undefined
sum(1, 2, 3, 4, 5, 6);
// 21
sum(1, 2, 3);
// NaN
sum = (a, b, c, d, e, f) => {
  console.log(a, b, c, d, e, f);
  return a + b + c + d + e + f;
};
// (a,b,c,d,e,f) => {
//     console.log(a,b,c,d,e,f);
//     return a+b+c+d+e+f;
// }
sum(1, 2, 3);
// VM4207:2 1 2 3 undefined undefined undefined
// NaN

// default parameters
sum = (a = 0, b = 0, c = 0, d = 0, e = 0, f = 0) => {
  console.log(a, b, c, d, e, f);
  return a + b + c + d + e + f;
};

/* 
sum(1,2,3)
VM4359:2 1 2 3 0 0 0
6
sum()
VM4359:2 0 0 0 0 0 0
0
*/

/* 
sum(1,2,3)
VM4359:2 1 2 3 0 0 0
6
sum(1,2,3,4,5,6,7,8)
VM4359:2 1 2 3 4 5 6
21
*/

// rest parameters
sum = (...params) => {
  console.log(params);
  let sumOfParams = 0;
  params.forEach((e) => (sumOfParams += e));
  return sumOfParams;
};

/* 
sum(1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,9)
VM4948:2 (20) [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
99
sum = (...params)=>{
  console.log(params);
  return params;
}
(...params)=>{
  console.log(params);
  return params;
}
sum(1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,9)
VM5194:2 (20) [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
(20) [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
const arr2 = [1,2,3]
undefined
arr2.push(sum(1,2,3,4,4,33,3,3,3,3,4,4))
VM5194:2 (12) [1, 2, 3, 4, 4, 33, 3, 3, 3, 3, 4, 4]0: 11: 22: 33: 44: 45: 336: 37: 38: 39: 310: 411: 4length: 12__proto__: Array(0)
4
const arr3 =[1,2,3]
undefined
arr3[4]=sum(1,2,3,4,4,44,3,3,3)
VM5194:2 (9) [1, 2, 3, 4, 4, 44, 3, 3, 3]
(9) [1, 2, 3, 4, 4, 44, 3, 3, 3]0: 11: 22: 33: 44: 45: 446: 37: 38: 3length: 9__proto__: Array(0)
console.log(arr3)
VM5843:1 (5) [1, 2, 3, empty, Array(9)]
undefined
console.log(...arr3)
VM5984:1 1 2 3 undefined (9) [1, 2, 3, 4, 4, 44, 3, 3, 3]
undefined
*/

//spread operator
//    unpackages an array
/* 
console.log(arr3)
VM5843:1 (5) [1, 2, 3, empty, Array(9)]
undefined
console.log(...arr3)
VM5984:1 1 2 3 undefined (9) [1, 2, 3, 4, 4, 44, 3, 3, 3]
undefined
*/
