// single-line comment
/*
    multi-line comment
*/

console.log("this is how you print inside js");

/*
    js is interpreted, never compiled
        made in 1995 by netscape for the Explorer browser
            js is mainly used for making pages dynamic;
            however, with the birth of nodejs,
            we've seen an explosion in full-stack js
        
        js has data types
            number, boolean, string, object, null, undefined, symbol, function
            important here are number and function
        how to declare variables
            var, let, const
                var is legacy; deprecated since 2015, DO NOT USE IN NEW CODE
                let is the new var
                const declares a constant
*/

/*
// js is loosely-typed; you can assign any type to any variable at any time
let s = "sfiufeg"; // string is still in the heap; heap is for ALL storage
s = 7;
s = true;
*/

// if you declare a variable, ALWAYS make it const unless there's a reason to change it later on

const bool = true;
const str = 'string'; // single or double quotes for strings
const sym = Symbol();
const obj = {name: 'james'}; // arrays (obj = [a,, b, ...]) are objects
const num = 8;
const fun = function(){} // js has semicolon injection; will insert semicolons where needed, but DO NOT RELY ON THIS
const nul = null; // null was never initialized by JAVASCRIPT
const und = undefined; // undefined has a name, has a space, was never given a value by YOU

//const undef; // EXCEPTION; missing initializer in a const declaration

/*
new Date()     // semicolon injection may put a semicolon here
    .getDate()
    .toExponential(); 
*/

// object literal notation
const o = {
    name: 'james',
    age: 6,
    stepsTaken: 0,
    walk: function(steps){
        this.stepsTaken += steps;
    }
};

// using a constructor
const date = new Date();
date.hammer = 8; // fields within a const object are not also const unless declared so
console.log(date.hammer);

// functions
//  notice no return type in function declaration
function sum(num1, num2){
    return num1+num2;
};

function retUndef(){
    return undefined;
};

function nothing(){}; // if JS returns nothing, then it's undefined

const sumVar = sum(1, 2), undef = retUndef(), some = nothing();
let nullo;

console.log(sumVar, undef, some, nul, nullo);

// declare functions
//  function syntax
function one(){} // historic syntax

// variable declaration syntax
const two = function two(){};

//anonymous functions
const three = function(){};

//arrow functions (like lambdas)
const four = () => {}; // Robert will use this; stay aware of the differences in the js "this" keyword

//functions are first-class citizens; they can be passed as variables
const five = console.log;
five('five function');

//callback
six = function(callback){
    // callbacks typically used for asynchronous operations and event handlers
    callback("some value");
};

// callback example
function call(){
    console.log("this is a callback");
}

setTimeout(
    call, // not call(); the variable is holding the function
//  ()=>{console.log("this is a callback");},
    3000
);

// js has allocation & initialization
//  functions are brought to the top of the page before interpretation
//      js doesn't know how much memory to allocate for a function, so it does this beforehand
//      "hoisting" - function declarations are brought to the top of their scopes and can be run before being declared
//      this is the two-stage memory bringing the function in and creating it before the initialization/invocation phase
//      hoisting does not work with variables

setTimeout(() => console.log("setTimeout with arrow function"), 1000);

//operators
/*
    typeof  returns a string representation of the variable type
    ==      equality with type coercion doesn't take data types into account;
                second operand gets converted into first's type (5 -> Number(5).toString() or "5" -> Number('5'))
    ===     equality without type coercion
    +       unary operator; converts operand into a number; +x is the same as Number(x)
    -       unary operator; same as above but will not concatenate if used as a binary operator
    isNaN   really a function; tells if the arguments evaluate to NaN
    eval    Don't.
*/

/*
    ('b' + 'a' + + 'a' + 'a') --> 'baNaNa'
*/


// all falsey values: 0, false, NaN, '', null, undefined
function isItTruthy(value){
    if(value){
        console.log(true);
    } else {
        console.log(false);
    }
};

// scopes
const val = true; // global scope
function check(){
    const maybe = "something"; // function scope
    if(val){
        const panic = "aaaaaa"; // block scope

        var messyScope = 'this is not block scope'; // function scope (even though inside a block)

        globalThing = 'this is also not block scope'; // global scope; BAD PRACTICE
    }
    console.log(panic);
}

const arr = ['alligator', 9, false, undefined, null, Symbol(), NaN];


// adds a new item 'hey'
arr.push('hey');

// arr.length = 1000; // can do it; don't do it. populates with empty values.

/*
// traditional for loop
for(index = 0; index < arr.length; index++){
        console.log(arr[index]);
    }

// for-of loop grabs the element
for(let i of arr){
    console.log(i);
}

// for-in loop grabs the index
for(let i in arr){
    console.log(i);
}
*/

// classes

// pre-2015
function Person(name, age){
    this.age = age;
    this.name = name;
    this.yell = () => {console.log(this.name.toUpperCase() + "!!!!!")};
}

const p = new Person('Harry', 12);
p.yell;



// post-2015
class Person2{
    constructor(name, age){
        this._name = name; // underscores are naming convention meaning these are meant to be used as private variables
        this._age = age;
    }

    yell(){
        console.log(this.name.toUpperCase() + "!?!?!?");
    }

    get name(){
        return this._name;
    }
    set name(name){
        this._name = name;
    }

    get age(){
        return this._age;
    }
    set age(age){
        this._age = age;
    }
}

const p2 = new Person2('Sarah', 24);
p2.yell;




// anonymous functions
// IIFE - immediately invokable function expression
const a = (
    function(){
        return 7;
    }
)(); // function is immediately invoked ater being defined in a block; a is assigned 7

// closure -- allows true encapsulation
const driveCar = (function(){
    console.log("the car has been purchased"); // only called once
    let miles = 0;
    return function (mile){
        console.log("the car has been driven " + mile + " miles");
        miles += mile;
        console.log("the current mileage is " + miles);
    }
})(); // returns the inner function

driveCar(500); // we don't have direct access to driveCar.miles, but we can still increment it
driveCar(500); // closure; this gives us true encapsulation!
driveCar(500); // may return an array of functions to get multiple encapsulated functions, but you'd need to reference with array index

const stringy = "this is a string, if we want to add variables such as " + arr
    + ", we  need to concatenate it in the string. If we want to create a line break," 
    + " we need to either add in the escape character \\ or we have to concatenate.";

    const betterStringy = `or we can use backticks and it will allow us to go to
        different lines without having to concatenate and if we want to throw in variables,
        we can use \${} syntax and add them in such as ${arr}. We ca also perform js code inside 
        the template literal such as ${driveCar()} ${console.log("hairy baby")}`;

// oop concepts in js
//      inheritance
//          prototype inheritance
//          classes are a blueprint, you inherit all of their properties, but prototypes are a skeleton of the object to build on top of
//          you can access the parent by using the prototype
//          there is no actual class-based inheritance; this is syntactic sugar to wrap prototype inheritance
//          setting a class extends just sets another layer to the prototype
//      polymorphism
//          no overloading, yes overriding
//      abstraction
//          modules; what are we exporting?
//      encapsulation
//          modules & closure (above)

const obj = {name: 'bob'};

obj.toString = function(){ return 'this is bob' };

obj.toString(); // 'this is bob'
obj.__proto__.toString();


obj.__proto__.toString() = function(){console.log('hey it\'s the proto')}; // don't do this; overrides toString for all Object-prototype-inheriting objects

const obj2 = {name: 'susan'};
obj2.toString(); // 'hey it's the proto!'

const obj3 = obj; // passes by reference!

obj3.toString(); // 'this is bob'

obj3.toString = () => 'obj3';

const obj4 = {}; // now references 

const obj5 = Object.create(obj); // {}

obj5.__proto__; // {name: 'bob'}




const date = Object.create(new Date()); // Date{}
date.__proto__; // 2020-10-20T21:01:58.536Z



// operators
//      short-circuiting operators
//          a || b
//              default operator
//              if a is falsey, default to being b
//          a && b
//              guard operator
//              if a is truthy, it's no longer guarding b
//          !!(a||b)
//              double-not; turns it into the boolean representation of the or-statement evaluation

// mozilla mdn and javascript.info are your big reference sources
// filter, foreach, and map are the big Array functions
// 

// function parameters and operator on them
function sum(a, b, c, d, e, f){
    return a+b+c+d+e+f;
}

sum(1, 2, 3); // NaN; d, e, and f are of type undefined

sum = (a, b, c, d=0, e=0, f=0){ // default parameters
    console.log(a, b, c, d, e, f);
    return a+b+c+d+e+f;
};

sum(1, 2, 3); // 6; d, e, and f are each 0

sum(1, 2, 3, 4, 5, 6, 7, 8); // adds 1 to 6, ignoring the rest

sum = (... params) => { // rest parameters; all inputs turned in as an array
    console.log(params);

    let sumOfParams = 0;

    params.forEach(e => sumOfParams += e); // each element e gets added to sumOfParams
    
    return sumOfParams;
};

sum = (... params) =>{
    console.log(params);
    return params;
}

const arr2 = [1,2,3];
arr2.push(sum(1, 2, 3, 4, 5)); // should put in the returned array as the 4th element (actually appends the 5 values)

console.log(arr2); // [1, 2, 3, Array(5)];

// spread operator unpackages an array
// console.log(... arr2); // 1 2 3 Array(5)