export class Popcorn {
  butterAmount: number;
  salty: boolean;
  isBurnt: boolean;
  toppings: {
    candy: string[];
    cheese: [string, number][];
    syrup: string[];
    strange: [string, number][];
  };
  constructor() {}

  ripBag: () => void = () => console.log("fall on floor");
}
