//objects

//object literal notation
const o = {
    name: "james",
    age: 6,
    stepsTaken: 0,
    walk: function (steps) {
      this.stepsTaken += steps;
    },
  };
  
  //using a constructor
  const date = new Date();
  date.hammer = 8;
  console.log(date.hammer);
  
  // classes
  
  // pre-2015 class
  function Person(name, age) {
    this.age = age;
    this.name = name;
    this.yell = function () {
      console.log(this.name.toUpperCase() + "!!!!!!!!");
    };
  }
  
  //post-2015 class
  class Person2 {
    constructor(name, age) {
      this._name = name;
      this._age = age;
    }
    yell() {
      console.log(this.name.toUpperCase());
    }
  
    get name() {
      return this._name;
    }
    set name(name) {
      this._name = name;
    }
  
    get age() {
      return this._age;
    }
  
    set age(age) {
      // this._age = age;
    }
  }