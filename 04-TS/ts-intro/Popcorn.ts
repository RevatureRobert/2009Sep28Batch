// export class Popcorn {
// public butterAmount: number;
// protected salty: boolean;
// private static readonly isBurnt: boolean;
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

//   ripBag: () => void = () => console.log("fall on floor");
// }
class Popcorn {
  constructor(
    private _butterAmount: number,
    private _salty: boolean,
    private _isBurnt: boolean,
    private _toppings: {
      candy: string[];
      cheese: [string, number][];
      syrup: string[];
      strange: [string, number][];
    }
  ) {}

  get butterAmount(): number {
    return this._butterAmount;
  }
  set butterAmount(amount: number) {
    this._butterAmount = amount;
  }

  get salty(): boolean {
    return this._salty;
  }
  set salty(salty) {
    this._salty = salty;
  }

  get isBurnt(): boolean {
    return this._isBurnt;
  }
  set isBurnt(burnt: boolean) {
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
  ripBag: () => void = () => console.log("fall on floor");
}
/* 
typescript has access and non access modifiers
  access modifiers
      private
      protected
      public (default)
  non access modifiers
      static
      readonly (final)
*/

export default Popcorn; //export in the declaration or later on
