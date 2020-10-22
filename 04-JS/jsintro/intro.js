//single line comment
/* multi line comment */
console.log("this is how you print inside js");

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

//!scopes
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

//!for of loop grabs the element
// for (let i of arr) {
//   console.log(i);
// }

//!for in loop grabs the index
// for (let i in arr) {
//   console.log(i);
// }

//!es6 template literals
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
