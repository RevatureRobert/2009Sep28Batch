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
const x = 8;
let anything = 0;
anything = true;
anything = ["kjsfhgudsfh"];
//number
const num = 9;
//boolean
const boo = true;
//void
const b1 = null;
//null
const n = null;
//undefined
let un;
//never
let no;
//arrays
const ar1 = ["ksldagh", "sakljfg"];
const ar2 = [3456, 3465];
const arar = [
    ["kjghkusd", "sfkljhgfud"],
    ["kjsfguidsh", "sklj;ghui"],
];
var weekdays;
(function (weekdays) {
    weekdays[weekdays["MONDAY"] = 3] = "MONDAY";
    weekdays[weekdays["TUESDAY"] = 6] = "TUESDAY";
    weekdays[weekdays["WEDNESDAY"] = 7] = "WEDNESDAY";
    weekdays[weekdays["THURSDAY"] = 8] = "THURSDAY";
    weekdays[weekdays["FRIDAY"] = 9] = "FRIDAY";
    weekdays[weekdays["SATURDAY"] = 10] = "SATURDAY";
    weekdays[weekdays["SUNDAY"] = 11] = "SUNDAY";
})(weekdays || (weekdays = {}));
console.log(weekdays.FRIDAY);
//tuple
const tup = ["skfjgh", 878, true];
console.log(tup);
console.log(...tup);
