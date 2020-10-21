// oop concepts in js
//inheritance
//polymorphism
//abstraction
//encapsulation
//inheritance: prototype inheritance (the skeleton of the object) (classes are sugar syntax for
//                                        prototype inheritance)
//polymorphism: overriding
//abstraction: modules
//encapsulation: modules, closure

// working with prototypes
// > const obj = {name:'bob'}
// undefined
// > obj
// { name: 'bob' }
// > obj.toString()
// '[object Object]'
// > obj.toString=function(){console.log('this is bob')}
// [Function]
// > obj.toString=function(){return 'this is bob'}
// [Function]
// > obj.toString()
// 'this is bob'
// > obj.__proto__.toString()
// '[object Object]'
// > obj.__proto__.toString=function(){return 'hey its the proto'}
// [Function]
// > obj.toString()
// 'this is bob'
// > obj.__proto__.toString()
// 'hey its the proto'
// > const obj2={name:'susan'}
// undefined
// > obj2.toString()
// 'hey its the proto'

//obj3=obj
// undefined
// > obj3.toString()
// 'this is bob'
// > obj3.toString=()=>'obj3'
// [Function]
// > obj3.toString()
// 'obj3'
// > obj.toString()
// 'obj3'
// > const obj4 = {}
// undefined
// > obj4.__proto__=obj
// { name: 'bob', toString: [Function] }
// > obj
// { name: 'bob', toString: [Function] }
// > obj.toString()
// 'obj3'
// > obj4
// {}
// > obj4.__proto__
// { name: 'bob', toString: [Function] }
// > obj4.toString()
// 'obj3'
// > obj4.toString=()=>'no more numbers'
// [Function]
// > obj4.toString()
// 'no more numbers'
// > obj4.__proto__.toString()
// 'obj3'
// > obj4
// { toString: [Function] }
// > const obj5 = Object.create(obj)
// undefined
// > obj5
// {}
// > obj5.__proto__
// { name: 'bob', toString: [Function] }
