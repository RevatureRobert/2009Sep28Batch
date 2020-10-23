console.log('this is typescript');
console.log('weeeeeedde');

// interface IObj {
// 	house;
// }

// class Obj implements IObj {
// 	house;
// }

const s1 = "string";

const s2: string = "string";

let anything: any = 0;
anything = true;
anything = ['array', 'array'];

enum weekdays {
  SUNDAY = 1,
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY
}

const fri: weekdays = weekdays.FRIDAY;
console.log(fri);

const tup:[string, number, boolean][] = [['string', 898, true]];

function hammer():void{
  console.log('Hammer hits the nail');
}

hammer();