// Comments are the same in node
console.log("This is how you print inside js.");
call();     // Hoisting
// console.log(bool);

// Js is loosely typed
// const s = "string";
// s = 7;
// s = true;

const bool = true;
const str = 'string';
const sym = Symbol();
const obj = {name:'james'};
const num = 8;
const fun = function(){}
const nul = null;
const und = undefined;
// const undef;            // Undefined by js;

// Object literal notation
const o = {
    name:'james',
    age:6,
    stepsTaken:0,
    walk: function(steps) {
        this.stepsTaken += steps;
    },
};

// Using a constructor
const date = new Date();
date.hammer = 8;
console.log(date.hammer);

// Functions

function sum(a,b) {
    return a+b;
}

function retUndef() {
    return undefined;
}

function nothing() {};

const sumVar=sum(1,2),
u = retUndef,
some = nothing;

console.log(sumVar, u, some);

// Function syntax
function one(){}
const two = function two(){};
const three = function(){};
const four = () => {};
const five = console.log;
const six = function(callback) {
    callback("some value");
}

// Example of callback
function call(){
    console.log("this is a callback");
}
setTimeout(call, 3000);
setTimeout(()=>console.log("asdasdasd"), 1000);

// Truthy and falsey
function isItTruthy(value) {
    if(value) {
        console.log(true);
    } else {
        console.log(false);
    }
}

// Scopes
const val = true;       // global
function check() {
    const maybe = "something";      // function
    if(val) {
        // const panic = "aaaaaaaAAAAAAAAAA";  // block
        // var panic = "aaaahhhhh";                // Function
        // panic = "something";                     // Bad practice
    }
    // console.log(panic);
}

const arr = ["alligator",9,false,undefined,null,Symbol(),NaN];

// for(let i = 0; i < arr.length; i++) {
//     console.log(arr[i]);
// }

// for(let i of arr) {
//     console.log(i);     // Prints elements
// }

// for(let i in arr) {
//     console.log(i);     // Prints indexes
// }

// Classes - Old way
function Person(name, age) {
    this.age=age;
    this.name=name;
    this.yell=function() {
        console.log(this.name.toUpperCase() + "!!!!!!!!!!!!");
    }
}

// Classes - New way
class Person2{
    constructor(name, age) {
        this.age=age;
        this.name=name;
    }
    yell() {
        console.log(this.name.toUpperCase());
    }

    get name() {
        return this._name;
    }

    set name(name) {
        this._name=name;
    }

    get age() {
        return this._age;
    }

    set age(age) {
        this._age=age;
    }

}

// IIFE (Immediately Invocable Function Expression)
const a = (function() {
    return 7;
})();

// Closure
const driveCar = (function () {
    console.log("Car has been purchased")
    let miles = 0;
    return function (mile) {
        console.log("the car has been driven "+mile+" miles");
        miles+=mile;
        console.log("The current milage is "+miles);
        return miles;
    }
})();