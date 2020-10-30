/*  TypeScript is a superset of JavaScript
        anything that is valid in js is also valid in TypeScript
        has additional features and syntax
        includes actual encapsulation
        has annotations (decorators)
        type safety
        debugging tools

TypseScript is...
    made by Microsoft for larger applications
    syntax is closer to oop (java/c#)
    ts is a strongly-typed language
    ts also has static type checking
        checks types at compile time
        (as opposed to dynamic checking where types are checked at runtime)
    

IN COMMAND LINE:
    tsc intro.ts
        this transpiles intro.ts to javascript intro.js
    node intro.ts
    node intro.js
        this runs the ts or js file
    tsc --watch [or -w] intro.ts
        this watches the ts for changes and updates the js when the ts is saved
    tsc --outFile something.js intro.ts
        changes the target output js file
    tsc -t es6 intro.ts
        allows transpilation using es6 (has let & const instead of var)
    tsc -t esnext intro.ts
        allows transpilation to the latest javascript version
    node
        lets you type js into the command line for manual checking
    npm init
        node project manager creation, for javascript project
        generates a package.json, which is like a pom.xml for your js project
    npm install typescript
        installs typescript onto the new npm project
        node-modules is a LARGE folder; use a ".gitignore" file to keep it from pushing
    npm uninstall -g typescript
        UNINSTALLS TYPESCRIPT
    npm run compile
        compiler, with source & target according to tsconfig.json in the current directory
    npm run start
        runs the project (and without "start", it'll run whatever is in the "test" field in package.json)
    npm i -g typescript
        INSTALLS TYPESCRIPT
    npm i -D typescript
        sets typescript as a dev dependency; will show up in "devDependencies" in package.json
        dev dependencies will not ship with the project or with the git push

npmjs.com

can use a tsconfig.json file to configure exporting behavior...

datatypes of TypeScript
    From JS:
        number, boolean, string, null, undefined, symbol, object, function, array
        Symbol
            is really a hashed set of alphanumeric characters and therefore can't be effectively overwritten
    In TS:
        enum
            like a Java enum but default values turn into numbers in js
        void
        never
            will never hold anything
            useful for void functions, as they should never return anything
        tuple
            array for multiple data types
            you declare what types go in and in what order
        any
            anything; the JavaScript datatype, takes any type
    
*/

// TypeScript will infer all types...
let s = "stringy";
// s = 7; // number is not string, so it won't allow this unless you use a special declarator to ignore type safety ...


// we can also declare the types
const x:number = 8;

let anything:any = 0;
anything = true;
anything = ['arp', {field: null}];

//number
const num:number = 9;

//boolean
const boo:boolean = true;

//void
const b1:void = null;

//null
const n:null = null;

//undefined
let un:undefined;

//never
let no:never;

//arrays
const ar1:string[] = ['ksl','adg'];
const ar2:number[] = [3456,3465];
const arar:string[][] = [['a', 'b'],['x', 'y']];

//enums
enum weekdays{
    MONDAY = 1,// does not absolutely need a corresponding value
    TUESDAY = 2,// if not assigned, its value will be its index as if it was an array
    WEDNESDAY = 3,// if one is assigned and the next one isn't, it'll increment the next ones by 1 per instance
    THURSDAY = 4,// for instance, if WED is 1 and THURS is undefined, THURS becomes 2
    FRIDAY = 5,
    SATURDAY = 6,
    SUNDAY = 0
}
const fri:weekdays = weekdays.FRIDAY;
console.log

//symbols
const sym:symbol = Symbol();

//tuple
const tup:[string, number, boolean] = ['boo', 878, true];
const tuparr:[boolean, null][] = [[true, null], [false, null]];
console.log(tup);
console.log(... tup); // deconstructs array into elements



//functions
//  the js way...
function hammer(){
    console.log('hammer the nail');
}
hammer();
//  the ts way...
function hammer2():void {
    console.log('hammer the HAMMERS, INTO THE NAILS')
}
hammer2();

function hammer3(num:number):string{
    return num.toString();
}
hammer3(7);
/*
function hammer3():void{ // overloading is not allowed!
    console.log('');
    return;
}
*/

const hammer4:Function = function():void{
    console.log('hammer TIME ITSELF');
}

const hammer5:Function = ():void => console.log('hammer MY OWN SELF');

let hammer6:Function;
hammer6 = ():void => console.log('hammer THE CONCEPT OF HAMMERS');
hammer6 = ():number => 3;

let hammer7:(num:number, num2:number) => number;
hammer7 = () => 7; // still need to give this function 2 number args, and still needs to return a number
hammer7(12, -4);
// the many function declaration types will be particularly useful for creating interfaces for react...



//interfaces
interface IRaccoon{
    sharpClaws:boolean; //  cannot define values for this
    stinkyAmount:number; //        interfaces are ONLY for describing the scructure, not defining the values
    eatTrash:(trash:string)=>void;
}

const rac1:IRaccoon = {
    sharpClaws:true,
    stinkyAmount:7.8,
    eatTrash: function(trash:string){
        console.log(trash.toUpperCase() + ", YUM YUM. ", this.sharpClaws);
    }
}
const rac2:IRaccoon = {
    sharpClaws:false,
    stinkyAmount:4.4,
    eatTrash: () => console.log("lemme eat that " + trash.toLowerCase() + ".")
}
rac1.eatTrash("dirty diapers");
rac2.eatTrash('99 bottles of beer');



console.log('ayy');
console.log('test update');

// interfaces are made to define the shape of an object, what all it should have ...
// has no corresponding js element
interface IObj { // naming convention is to start interfaces with a capital I
    house;
}

class Obj implements IObj{
    house;
}