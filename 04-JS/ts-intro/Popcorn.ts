export class Popcorn {
  public butterAmount: number;
  protected salty: boolean;
  private static readonly isBurnt: boolean;
  toppings: {
    candy: string[];
    cheese: [string, number][];
    syrup: string[];
    strange: [string, number][];
  };
  constructor() {}

  ripBag: () => void = () => console.log("fall on the floor");
}

/*

