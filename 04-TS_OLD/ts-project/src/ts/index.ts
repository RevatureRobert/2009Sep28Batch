// console.log("this is a ts project");

// /*
// npm i -D @types/node
//     in the command line, this will give access to the process type...
// tsc

// npm i -D @babel/core @babel/cli @babel/preset-env

// npm i @babel/polyfill

// npm i -D babel-preset-minify
//  add to babel.config.json as another inner array of "presets":
//  [
//    "minify"
//  ],
// npm i -D jest @types/jest
//     unit testing tool -- jestjs.io
//     "test":"echo \"Error: no test specified\" && exit 1",
//         replaced with
//     "test":"jest",
//         in
//     tsconfig.json
// npm i -D @babel/preset-typescript
// npx jest --init
//     yes, node, yes, babel, yes
// npm i -D ts-jest


// */

// console.log(process.env.PATH);

// function print(){
//     console.log("decorator called");
//     return function(target, propertyKey:string, rescriptor:PropertyDescriptor){
//         console.log("print invoked ", target);
//     }
// }


// // Decorator annotation; re-implements the class, function, method, or field that it points toward
// class A{
//     @print()
    
//     someMethod(){}
// }
//


export default function cat(s1:string, s2:string):string{
    return s1 + s2;
}