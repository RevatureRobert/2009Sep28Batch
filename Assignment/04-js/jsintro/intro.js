//single line comment
/* multi line comment */
console.log("This is how you print inside js");
call(); //hoisting is where a function will be brought to the
            //top of its scope and can be ran before being declared
            //realistically, this is the two stage memory bringing
            //the function in and creating it before the initialization/invocation phase

/*
    javascript is interpreted, never compiled. 
        made in 1995 by netscape for the explorer browser
        js is mainly used for making pages dynamic, however
            with the birth of nodejs we have seen an explosion in full stack js.

    js has 8 data types
        number(instead of ints, floats), boolean, string, object, null, undefined, symbol, function. 
    how we declare variables
        var, let, const
        - never use var, it's kept for backward compatability but let and const
            are the new keywords. 
        - let is the new var
        - const declares a constant. can't be reassigned. like final in java 
    js has heap and stack
        - heap is for all objects, stack is only for function calls. 
    2 stages of memory allocation
    -general
    1. Initializiation
    2. Invocation
        - for variables:
            1. creates space for the variable
            2. is given a value line by line
        - for functions: hoisting
            1. initiazized before invocation. 
    
*/
// js is loosely type, you can assign any data type to any variable at any time. 
// let s = "ahram"; 
//  s= true;
//  s = 7; 

//use const unless it needs to be changed later on. 
const bool = true;
const str = 'string'; //you can use single or double quotes for strings. 
const sym = Symbol();
const obj = {name:'james'};
const num = 8;
const fun = function(){};
const nul = null; //  on initialization of variables, if it has no value its null. 
const und = undefined; //on creation, it has a name and space. 
//undefined is when js doesn't give it a value, null is when YOU don't give a value. 

//objects in js
//use curly braces for object literal notation
const o ={
    name:'james',
    age:6,
    stepsTaken:0,
    walk: function(steps){
        this.stepsTaken += steps;
    },
};

//using a constructor 
const date = new Date();
//we can use the . operator to add new values. 
date.hammer=8;
console.log(date.hammer);

//functions
//notice there is no return type. doesn't matter, loosely typed. 
function sum(a,b){
    return a+b;
}

function retUndef(){
    return undefined;
}
//this returns nothing, so its undefined. 
function nothing(){}

const sumVar = sum(1,2), undef = retUndef(), some = nothing();

console.log(sumVar, undef, some);

//declaring functions
//function syntax
function one(){}

//variable declaration syntax
const two = function two (){}

//anoynmous functions
const three = function(){}

//arrow functions
const four = () => {};

//functions are first class citizens
//they can be passed in as variables
const five = console.log;

//callbacks: used for asynchronous operations and event handlers, like clicking a button. 
const six = function (callback){
    callback("some value");
};

//callback example
function call(){
    console.log("this is a callback");
}
setTimeout(call,3000); //puts call function into the stack after 3 seconds. 
setTimeout(() => console.log("anonymous function"), 3000);

//operators
/*
    typeof : returns the string representation of the data type fo the operand
    == : this operator doesn't take data types into account, uses type coercion
    === : this operator checks for types
    +x : converts x into a number. the whole x. 
    -x : converts x into a number
    isNaN : returns a boolean if the operand is not a number. 
    don't use eval!! 
*/
console.log(typeof 5)


//truthy and falsey
//falsey values: 0, false, NaN, ""(empty string), null, undefined
//truthy values: anything that is not falsey. 
function isItTruthy(value){
    if(value){
        console.log(true);
    } else{
        console.log(false);
    }
}


//scopes
//let and const have block scope, and var does not have block scope, just function scope. 
//default is global scope. bad practice, always declare let or const. 
//const val = true;                                        //global scope
//let val = true;                                           //global
var val = true;                                           //global
function check(){                                                   
   // const maybe = "something";                           //function scope                      
   //let maybe = "something";                              //function scope
   //var maybe = 'something';                                 //function scope
    if(val){
        //const panic = "aaaaaaaaaahhh";                   //block scope
        //let panic = "aaaaaaah";                        //block scope
        var panic = "aaaaaaaaaaaaaah"                   //function scope. 
        //panic = "something"; //this is very bad practice, default global scope. 
    }
    //console.log(panic);
}



const arr = ["alligator", 9, false, undefined, null, Symbol(),NaN];
// for(let i = 0; i<arr.length; i++){
//     console.log(arr[i]);
// }

//for of loop grabs the element like a for:each
// for(let i of arr){
//     console.log(i);
// }

//for in loop. prints the index. 
// for(let i in arr) {
//     console.log(i);
// }

array.forEach(element => {
    
});

//classes

//prior to 2015
function Person(name, age){
    this.age = age;
    this.name = name;
    this.yell = function (){
        console.log(this.name.toUpperCase() + "!!!!!");
    }
}

//post 2015 class
class Person2{
    constructor (name, age){

        // put a _ underscore before the name to make it implicitly private. 
        this._name = name;
        this._age = age;
        //this is make believe encapsulation. 
    }
    yell(){
        console.log(this.name.toUpperCase());
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

//anonymous functions

//IIFE = Immediately Invokable function expression, put function inside parantheses
const a = (function(){
    return 7;
})()

//closure -- way to encapsulate. combine a anonymous function with IIFE
//encloses the function into the parent scope. 
// the first function is called in the beginning, and it returns the function(mile), so 
// thats what driveCar ends up holding, the 
const driveCar = (function(){
    console.log("the car has been purchased");
    let miles = 0;
    return function(mile){
        console.log("the car has been driven " + mile + " miles");
        miles += mile;
        console.log("The current mileage is " + miles);
        return miles;
    }    
}) (); // the last two parentheses invoke the function. 

//ecma script is the standard for scripting languages. 
//ecma stands for european computer manufacturer's association
//javascript is the implementation of ecma script. 


const stringy = "this is a string, if we want to add in variables such as " + 
arr+ 
" we need to concatenate it in the string. " +
"if we want to create a line break, we need to either add in the escape character \\ or we have to concatenate";

const betterStringy = `or we can use backticks and it will allow us to go to different lines without
    having to concatenate and if we want to throw in variables, we can use \${} syntax and add them in such
    as ${arr}. we can also perform js code inside the template literal such as ${driveCar()}
    ${console.log("hairy baby")}`;

    //oop concepts in js
    //inheritance
    //polymorphism
    //abstraction
    //encapsulation
    //
    //inheritance: prototype inheritance. (The skeleton of the object). (classes are sugar syntax 
    //                                                                     for prototype inheritance)
    //polymorphism: overriding methods. 
    //abstraction: modules.
    //encapsulation: modules, closure. 


    //operators
    //       short circuiting 
    //         || is known as the default operator. if the first value is false, the second value will be called. 
    //         && is known as the guard operator. It returns whatever made it stop. 

// !operators
//    !short circuiting
//      !default operator
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

//    !guard operator
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