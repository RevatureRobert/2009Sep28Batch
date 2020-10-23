/* 
We need to transpile the ts into js
  we can use tsc <fileName.ts>
  we can enter watch mode with tsc --watch [-w] <fileName.ts>
  there are several other options for the typescript compiler

typescript is a superset of javascript
  anything you can do in js, you can do in ts
  ts offers additional features and syntax

  typescript was developed by microsoft
  made for larger applications. the syntax is closer to java/c#
  ts is a strongly typed language.
  it also uses static type checking.
    static type checking checks the types at compile time
    dynamic type checking checks types at runtime
  
datatypes of typescript
    number, boolean, string, null, undefined, any
      symbol, function, object, array, enum, void, never, tuple
*/

//typescript will infer the types
let s1 = "stringy";
// s1 = 7;

//or we can declare the types
const x: number = 8;

let anything: any = 0;
anything = true;
anything = ["kjsfhgudsfh"];

//number
const num: number = 9;

//boolean
const boo: boolean = true;

//void
const b1: void = null;

//null
const n: null = null;
//undefined
let un: undefined;
//never
let no: never;

//arrays
const ar1: string[] = ["ksldagh", "sakljfg"];
const ar2: number[] = [3456, 3465];
const arar: string[][] = [
  ["kjghkusd", "sfkljhgfud"],
  ["kjsfguidsh", "sklj;ghui"],
];
enum weekdays {
  MONDAY = 3,
  TUESDAY = 6,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY,
}

console.log(weekdays.FRIDAY);

//tuple
const tup: [string, number, boolean] = ["skfjgh", 878, true];

//functions
//the js way

function hammer() {
  console.log("hammer the nail");
}

hammer();

//ts way
function hammer2(): void {
  console.log("hammer the nail");
}

hammer2();

function hammer3(num: number): string {
  return num.toString();
}

hammer3(7);

const hammer4: Function = function (): void {
  console.log("whatever");
};

const hammer5: Function = (): void => console.log("wha????");

let hammer6: (num: number, num2: number) => number;

// hammer6 = ():void => console.log("kjfshgue");
hammer6 = () => 7;

hammer6(45848, 47847);

//interfaces
interface IRaccoon {
  sharpClaws: boolean;
  stinkyAmount: number;
  eatTrash: (trash: string) => void;
}

const rac1: IRaccoon = {
  sharpClaws: true,
  stinkyAmount: 7.8,
  eatTrash: function (trash: string) {
    console.log("i have eaten all of the " + trash);
  },
};

const rac2: IRaccoon = {
  sharpClaws: true,
  stinkyAmount: 7.8,
  eatTrash: (trash) => console.log("i have eaten all the " + trash),
};

rac1.eatTrash("dirty diapers");
rac2.eatTrash("99 beers on the wall");
