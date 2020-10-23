console.log("this is a ts projectdxflkgjndlirfgukhg");
console.log(process.env.PATH);

function print() {
  console.log("decorator called");
  return function (
    target,
    propertyKey: string,
    descriptor: PropertyDescriptor
  ) {
    console.log("print invoked ", target);
  };
}

class A {
  @print()
  someMethod() {}
}
