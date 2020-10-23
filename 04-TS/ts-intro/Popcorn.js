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
export class Popcorn {
    constructor(butterAmount, salty, isBurnt, toppings) {
        this.butterAmount = butterAmount;
        this.salty = salty;
        this.isBurnt = isBurnt;
        this.toppings = toppings;
        this.ripBag = () => console.log("fall on floor");
    }
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
