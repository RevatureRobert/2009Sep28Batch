// Comments are the same in node
console.log("This is how you print inside js.");

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