/*INTRO TO TYPESCRIPT
number 1 rule: if you know javascript, you know typescript. 
plain javascript works in typescript, but typescript is a super set of javascript. 
BUT web browsers can't run typsecript, so you convert typescript to javascript using tsc [filename] command. 
converting typescript to javascript is called transpiling. 
*/
console.log('this is typescript');
console.log("does this work");

//use tsc --watch [.tsc file] to have it transpile to js automatically
console.log("this gets copied");

/*
We need to transpile the ts into js
    we can use tsc <filename.ts>
    use tsc -t esnext <filename.ts> to get the lastest javascript version
    we can enter watchmode with tsc --watch [or -w] <fileName.ts>
    there are serveral other options for the typescript compiler

typescript is a superset of javascript
    anything you can do in js, you can do in ts
    ts offers additional features and syntax. 

    typescript was developed by Microsoft
    made for larger applications. the syntax is closer to java/c#
    ts is a strongly typed language.
    it also uses static type checking. 
     ***** static vs dynamic type checking*****
                - static checks at compile time
                - dynamic checks at runtime.
    
datatypes of typescript
    number, boolean, string, null, undefined, any, symbol, function, 
    object, array, enum, void ,never, tuple
*/

//access modifiers and classes in Popcorn.ts

//typescript will infer the types
let s1 = "stringy";
// s1 = 7;

//or we can declare the types
const x:number = 8;

let anything:any = 0;
anything = true;
anything = ['kjkjkjkjkj]'];

//number
const num:number = 9;

//bolean 
const boo:boolean = true;

//void is used for functions
const b1:void = null;

//null
const n:null = null;

//undefined
let un:undefined;

//never mean it will never hold anything
//useful for functions that will never return anything
let no:never;

//arrays
const ar1:string[] = ['fjfjfjfj','fjfjfjf'];
const ar2:number[] = [333,1234];
const arar:string[][] = [
    ["abc","def"],
    ["ghi","jkl"]
];

//enum
//if you don't assign variables, it assigns values starting from 0, 
//it assigns values starting from the last assignment, if monday started at 3
// it would increment tuesday to 4. 
//if the enum value isn't specified it increments from the last enum value that was specified. 
enum weekdays{
    MONDAY = 2,
    TUESDAY,
    WEDNESDAY = 1,
    THURSDAY = 5,
    FRIDAY = 6, 
    SATURDAY = 7,
    SUNDAY = 1
}

const fri:weekdays = weekdays.FRIDAY;
console.log(fri);// should return the value, 6

//tuple
const tup:[string, number, boolean] = ["ahram", 123, true];
//tuple array
const tuparr:[string,number,boolean][] = [["ahram",123,true], ["cho",456,false]];

//functions the js way
function hammer(){
    console.log('hammer the nail');
}

hammer();

//ts way
//you can use : to specify the return type of the function. 
function hammer2():void{
    console.log('hammer the nail');
}

hammer2();

function hammer3(num:number):string{
    return num.toString();
}

hammer3(5);

//declaring the type of hammer4
const hammer4:Function = function ():void{
    console.log("whatever");
}
//declaring the type ofhammer5 but with arrow function. 
const hammer5:Function = ():void => console.log("what??");

//when you declare a variable as a function without initializing, 
//it can take in whatever parameters and returns anything
// let hammer6:Function;
// hammer6 = ():string=> 'string';
// hammer6 = ():number => 5;     //these are ok


//to define the parameters and return type of the function:
//use arrow function. this is just the method signature
//takes in two number parameters and returns a type number. 
let hammer6:(num:number, num2:number) => number;
//you can access the two parameters naming them whatever
hammer6 = (ace, beta) => ace + beta;
//or you don't have to use the two parameters
hammer6 = ()=>6;

console.log(hammer6(444678,321));

//interfaces
interface IRaccoon{
    sharpClaws:boolean;
    stinkyAmount:number;
    eatTrash:(trash:string)=>void;
}

//this rac1 uses the interface IRacoon in ts
const rac1:IRaccoon = {
    sharpClaws:true,
    stinkyAmount:33,
    //using anonymous function, 'this refers to the object
    eatTrash: function(trash:string){
        console.log("i haven't eaten all of the " + trash);
    }
};

const rac2:IRaccoon = {
    sharpClaws:true,
    stinkyAmount:33,
    //when you use arrow function, 'this' refers to global scope(?)
    eatTrash: trash=> console.log("I have eaten all the " + trash)
};

rac1.eatTrash("yummy food");
rac2.eatTrash('dirty food');

//for classes check popcorn.ts

