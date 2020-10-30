/*
export class Popcorn{
    
    public butterAmount:number;
    protected salty:boolean;
    private static readonly isBurnt:boolean;
    toppings:{
        candy:string[],
        cheese:[string, number][],
        syrup:string[],
        strange:[string, number][]
    }
    
    constructor(
        public butterAmount:number,
        public salty:boolean,
        public isBurnt:boolean,
        public toppings:{
            candy:string[],
            cheese:[string, number][],
            syrup:string[],
            strange:[string, number][]
        }
        ){
            
            this.butterAmount = _butterAmount;
            this.salty = _salty;
            this.isBurnt = _isBurnt;
            this.toppings = _toppings;
            
        }
        
        ripBag:()=>void = () => console.log("fall on floor");
}*/
    
// access modifiers next to the constructor parameters defines them as object properties / fields
// the below class is equivaltent to the above class
/*export default*/ class Popcorn{
    constructor(
        private _butterAmount:number,
        private _salty:boolean,
        private _isBurnt:boolean,
        private _toppings: {
            candy: string[];
            cheese: [string, number][];
            syrup: string[];
            strange: [string, number][];
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
        set salty(salty){
            this._salty = salty;
        }
        
        get isBurnt():boolean{
            return this._isBurnt;
        }
        set isBurnt(burnt){
            this._isBurnt = burnt;
        }
        public get toppings(): {
            candy: string[];
            cheese: [string, number][];
            syrup: string[];
            strange: [string, number][];
        } {
            return this._toppings;
        }
        public set toppings(value: {
            candy: string[];
            cheese: [string, number][];
            syrup: string[];
            strange: [string, number][];
        }) {
            this._toppings = value;
        }
        
        ripBag:()=>void = () => console.log("fall on floor");
    }
    
    /*
    typescript has access and non-access modifiers
    access modifiers
    private
    protected
    public (default)
    non-access modifiers
    static
    readonly (final)
    */

    export default Popcorn;