/*
We need to transpile the ts into js
we can use tsc <fileNAme.ts>
we can enter watchj mode with tsc
*/

const s1 = "stringy";
// s1 = 7

const x: number = 8;

let anything: any = 0;
anything = true;
anything = ["asdf"];

//number
const numb: number = 9;

const boo: boolean = true;
const b1: void = null;

const n: null = null;

let un: undefined;

let no: never;

const ar1: string[] = ["asdf", "asdf"];
const ar2: number[] = [123, 123];

enum weekday {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY,
}

const fri: weekdays = weekdays.FRIDAY;
console.log(fri);

const tup: [string, number, boolean] = [["cunt", 7, true]];
console.log(tup);

function hammer() {
  console.log("hammer the nail");
}

hammer();

function hammer2(): void {
  console.log("hammer the nail");
}

hammer2();

function hammer3(num: number): string {
  return num.toString();
}

hammer3(7);

const hammer4: Function = function (): void {
  console.log("whatever");
};

const hammer5: Function = (): void => console.log("waaaaaa");

let hammer6: (num: number, num2: number) => number;

// hammer6 = (): void => console.log("asdf");

hammer6 = (): number => 7;

hammer6(123, 123);

interface IRacoon {
  sharpClaws: boolean;
  stinkyAmount: number;
  eatTrash: (trash: string) => void;
}

const rac1: IRacoon = {
  sharpClaws: true,
  stinkyAmount: 7.8,
  eatTrash: function (trash: string) {
    console.log("I eat da " + trash);
  },
};

const rac2: IRacoon = {
  sharpClaws: true,
  stinkyAmount: 7.8,
  eatTrash: function (trash: string) {
    console.log("I eat da " + trash);
  },
};

rac1.eatTrash("dirty diapers");
