// console.log("hello");
// const hello: string = "hello";
// console.log(process.env.PATH);
// function print() {
//   console.log("decorator called");
//   return function (
//     target,
//     propertyKey: string,
//     descriptor: PropertyDescriptor
//   ) {
//     console.log("print invoked ", target);
//   };
// }
// class A {
//   @print()
//   someMethod() {}
// }
export default function cat(s1, s2) {
    return s1 + s2;
}
