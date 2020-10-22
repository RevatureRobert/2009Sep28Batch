//array methods
/* 
const arr = ['alligator','kangaroo',11,undefined, 77]
undefined
arr
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter((element) => {
    return typeof element === 'string';
})
(2) ["alligator", "kangaroo"]
arr
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter(e=>typeof e === 'string')
(2) ["alligator", "kangaroo"]
arr.filter(e=>true)
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter(e=>false)
[]
arr.filter(e=>elide)
(5) ["alligator", "kangaroo", 11, undefined, 77]
arr.filter(e=>e)
(4) ["alligator", "kangaroo", 11, 77]
arr.forEach(e=>console.log(e))
VM2475:1 alligator
VM2475:1 kangaroo
VM2475:1 11
VM2475:1 undefined
VM2475:1 77
undefined
arr.forEach(console.log)
VM2558:1 alligator 0 (5) ["alligator", "kangaroo", 11, undefined, 77]0: "alligator"1: "kangaroo"2: 113: undefined4: 77length: 5__proto__: Array(0)
VM2558:1 kangaroo 1 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2558:1 11 2 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2558:1 undefined 3 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2558:1 77 4 (5) ["alligator", "kangaroo", 11, undefined, 77]
undefined
arr.forEach((element, index, array) => console.log(element, index, array))
VM2789:1 alligator 0 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 kangaroo 1 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 11 2 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 undefined 3 (5) ["alligator", "kangaroo", 11, undefined, 77]
VM2789:1 77 4 (5) ["alligator", "kangaroo", 11, undefined, 77]
undefined
arr.filter
ƒ filter() { [native code] }
arr.filter((e,i,a,b,v,c)=>console.log(e,i,a,b,v,c))
VM3089:1 alligator 0 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 kangaroo 1 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 11 2 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 undefined 3 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
VM3089:1 77 4 (5) ["alligator", "kangaroo", 11, undefined, 77] undefined undefined undefined
[]
arr.map(e=>+e)
(5) [NaN, NaN, 11, NaN, 77]
arr.map(e=>console.log())
(5) [undefined, undefined, undefined, undefined, undefined]
arr.map(e=>console.log(e))
VM3360:1 alligator
VM3360:1 kangaroo
VM3360:1 11
VM3360:1 undefined
VM3360:1 77
(5) [undefined, undefined, undefined, undefined, undefined]
*/