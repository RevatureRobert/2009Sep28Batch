/*
We need to transpile the ts into js
we can use tsc <fileNAme.ts>
we can enter watchj mode with tsc
*/
var s1 = "stringy";
// s1 = 7
var x = 8;
var anything = 0;
anything = true;
anything = ["asdf"];
//number
var numb = 9;
var boo = true;
var b1 = null;
var n = null;
var un;
var no;
var ar1 = ["asdf", "asdf"];
var ar2 = [123, 123];
var weekday;
(function (weekday) {
    weekday[weekday["MONDAY"] = 0] = "MONDAY";
    weekday[weekday["TUESDAY"] = 1] = "TUESDAY";
    weekday[weekday["WEDNESDAY"] = 2] = "WEDNESDAY";
    weekday[weekday["THURSDAY"] = 3] = "THURSDAY";
    weekday[weekday["FRIDAY"] = 4] = "FRIDAY";
    weekday[weekday["SATURDAY"] = 5] = "SATURDAY";
    weekday[weekday["SUNDAY"] = 6] = "SUNDAY";
})(weekday || (weekday = {}));
var fri = weekdays.FRIDAY;
console.log(fri);
