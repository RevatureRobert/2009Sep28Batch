// console.log("this is a sdklfjsdlkjfds");
// console.log(process.env.PATH);
// function print(){
//     console.log("decorator called");
//     return function(target, propertyKey:string, descriptor:PropertyDescriptor){
//         console.log("print invoked", target);
//     };
// }
// class A{
//     @print()
//     someMethod(){}
// }
export default function concat(s1, s2) {
    return s1 + s2;
}
