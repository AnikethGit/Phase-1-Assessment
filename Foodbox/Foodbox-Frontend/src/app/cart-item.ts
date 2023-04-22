import { Dish } from "./dish";

export class CartItem {
    did!: number;
    name!: string;
    course!: string;
    price!: number;
    img!: any;
    quantity!: number;

    constructor(dish: Dish) {
        this.did = dish.did;
        this.name = dish.name;
        this.course = dish.course;
        this.price = dish.price;
        this.img = dish.img;
        this.quantity = 1;
    }
}