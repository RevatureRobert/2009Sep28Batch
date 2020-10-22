/*
typescript has access and non access modifiers
by default, access modifiers are public.
(package will be folder)
    access modifiers:
        private
        protected
        public (default)
    non-access modifiers:
        static-only the class
        readonly (final)

*/
//export keyword makes it available for import
// export class Popcorn {
// // public butterAmount: number;
// // protected salty: boolean;
// // private static readonly isBurnt: boolean;
//   butterAmount: number;
//   salty: boolean;
//   isBurnt: boolean;
//   toppings: {
//     candy: string[];
//     cheese: [string, number][];
//     syrup: string[];
//     strange: [string, number][];
//   };
//   constructor(_butterAmount: number,
//     _salty: boolean,
//     _isBurnt: boolean,
//     _toppings: {
//       candy: string[];
//       cheese: [string, number][];
//       syrup: string[];
//       strange: [string, number][];
//     }) {
//       this.butterAmount=_butterAmount;
//       this.salty=_salty;
//       this.toppings=_toppings;
//       this.isBurnt=_isBurnt;
//     }
//     //ripBag is initialized as type function that takes no parameters and returns void
//     //              initialized to print out fall on floor. 
//     ripBag:()=> void = ()=> console.log("fall on floor");
// }
//use public access modifier to declare variables inside the constructor
export class Popcorn {
    //when you put public access modifier next to the variables within the constructor method,
    //it says that those variables are not method(constructor) scope, but function scope. 
    constructor(_butterAmount, _salty, _isBurnt, toppings) {
        this._butterAmount = _butterAmount;
        this._salty = _salty;
        this._isBurnt = _isBurnt;
        this.toppings = toppings;
        //ripBag is initialized as type function that takes no parameters and returns void
        //              initialized to print out fall on floor. 
        this.ripBag = () => console.log("fall on floor");
    }
    get butterAmount() {
        return this._butterAmount;
    }
    set butterAmount(amount) {
        this._butterAmount = amount;
    }
    get salty() {
        return this._salty;
    }
    set salty(isSalty) {
        this._salty = isSalty;
    }
    get isBurnt() {
        return this._isBurnt;
    }
    set isBurnt(burnt) {
        this._isBurnt = burnt;
    }
}
