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
//use default to make this class the default imported class in other files. 
//you can also put export later on, not just in the declaration
export class Popcorn {
    //when you put public access modifier next to the variables within the constructor method,
    //it says that those variables are not method(constructor) scope, but function scope. 
    constructor(
        private _butterAmount:number,
        private _salty:boolean,
        private _isBurnt:boolean,
        public toppings: {
            candy:string[], 
            cheese: [string,number][], //an array of arrays that take in string and number
            syrup: string[], 
            strange:[string, number][]
        }
    ){}

    get butterAmount():number{
        return this._butterAmount;
    }
    set butterAmount(amount:number){
        this._butterAmount = amount;
    }
    get salty():boolean{
        return this._salty;
    }
    set salty(isSalty:boolean){
        this._salty = isSalty;
    }
    get isBurnt():boolean{
        return this._isBurnt;
    }
    set isBurnt(burnt:boolean){
        this._isBurnt = burnt;
    }

    //ripBag is initialized as type function that takes no parameters and returns void
    //              initialized to print out fall on floor. 
    ripBag:()=> void = ()=> console.log("fall on floor");
}


export default Popcorn; //export later on. 
