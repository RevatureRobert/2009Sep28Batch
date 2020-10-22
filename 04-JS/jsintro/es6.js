//function parameters and operator on them
function sum(a, b, c, d, e, f) {
  return a + b + c + d + e + f;
}

// undefined
sum(1, 2, 3, 4, 5, 6);
// 21
sum(1, 2, 3);
// NaN
sum = (a, b, c, d, e, f) => {
  console.log(a, b, c, d, e, f);
  return a + b + c + d + e + f;
};
// (a,b,c,d,e,f) => {
//     console.log(a,b,c,d,e,f);
//     return a+b+c+d+e+f;
// }
sum(1, 2, 3);
// VM4207:2 1 2 3 undefined undefined undefined
// NaN

// default parameters
sum = (a = 0, b = 0, c = 0, d = 0, e = 0, f = 0) => {
  console.log(a, b, c, d, e, f);
  return a + b + c + d + e + f;
};

/* 
sum(1,2,3)
VM4359:2 1 2 3 0 0 0
6
sum()
VM4359:2 0 0 0 0 0 0
0
*/

/* 
sum(1,2,3)
VM4359:2 1 2 3 0 0 0
6
sum(1,2,3,4,5,6,7,8)
VM4359:2 1 2 3 4 5 6
21
*/

// rest parameters
sum = (...params) => {
  console.log(params);
  let sumOfParams = 0;
  params.forEach((e) => (sumOfParams += e));
  return sumOfParams;
};

/* 
sum(1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,9)
VM4948:2 (20) [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
99
sum = (...params)=>{
  console.log(params);
  return params;
}
(...params)=>{
  console.log(params);
  return params;
}
sum(1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,9)
VM5194:2 (20) [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
(20) [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
const arr2 = [1,2,3]
undefined
arr2.push(sum(1,2,3,4,4,33,3,3,3,3,4,4))
VM5194:2 (12) [1, 2, 3, 4, 4, 33, 3, 3, 3, 3, 4, 4]0: 11: 22: 33: 44: 45: 336: 37: 38: 39: 310: 411: 4length: 12__proto__: Array(0)
4
const arr3 =[1,2,3]
undefined
arr3[4]=sum(1,2,3,4,4,44,3,3,3)
VM5194:2 (9) [1, 2, 3, 4, 4, 44, 3, 3, 3]
(9) [1, 2, 3, 4, 4, 44, 3, 3, 3]0: 11: 22: 33: 44: 45: 446: 37: 38: 3length: 9__proto__: Array(0)
console.log(arr3)
VM5843:1 (5) [1, 2, 3, empty, Array(9)]
undefined
console.log(...arr3)
VM5984:1 1 2 3 undefined (9) [1, 2, 3, 4, 4, 44, 3, 3, 3]
undefined
*/

//spread operator
//    unpackages an array
/* 
console.log(arr3)
VM5843:1 (5) [1, 2, 3, empty, Array(9)]
undefined
console.log(...arr3)
VM5984:1 1 2 3 undefined (9) [1, 2, 3, 4, 4, 44, 3, 3, 3]
undefined
*/
