//export keyword makes it available for import
export class Popcorn {
    constructor() {
        //ripBag is initialized as type function that takes no parameters and returns void
        //              initialized to print out fall on floor. 
        this.ripBag = () => console.log("fall on floor");
    }
}
