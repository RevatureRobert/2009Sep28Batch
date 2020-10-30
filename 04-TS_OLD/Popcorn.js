var Popcorn = /** @class */ (function () {
    function Popcorn() {
        this.ripBag = function () { return console.log("fall on floor"); };
    }
    return Popcorn;
}());
var oddcorn = new Popcorn();
// oddcorn.toppings.strange.push(['hot sauce', 3.4], ['horse radish', 0.2]); // this array is uninitialized, so you can't push to it!
oddcorn.toppings = { strange: [], cheese: [] };
oddcorn.toppings.strange.push(['hot sauce', 3.4], ['horse radish', 0.2]); // can push to it now!
oddcorn.toppings.cheese = [['parmesan', 4.2]];
oddcorn.butterAmount = 2;
oddcorn.salty = false;
oddcorn.isBurnt = false;
console.log(oddcorn);
console.log(JSON.stringify(oddcorn));
var username = 'summat';
var obj = {
    popcorn: {
        oddcorn: oddcorn,
        pop: "yes",
        username: username,
        name: username
    }
};
