//export keyword makes it available for import
export class Popcorn {
    butterAmount: number;
    salty: boolean;
    isBurnt: boolean;
    toppings: {
        candy:string[], 
        cheese: [string,number][], //an array of arrays that take in string and number
        syrup: string[], 
        strange:[string, number][]}
    constructor(){}

    //ripBag is initialized as type function that takes no parameters and returns void
    //              initialized to print out fall on floor. 
    ripBag:()=> void = ()=> console.log("fall on floor");

}

