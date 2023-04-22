import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartItem } from 'src/app/cart-item';
import { Dish } from 'src/app/dish';
import { CartService } from 'src/app/Services/cart.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-search-dish',
  templateUrl: './search-dish.component.html',
  styleUrls: ['./search-dish.component.css']
})
export class SearchDishComponent implements OnInit {
  foodName!: string;
  name!: string;
  dish!: Dish[];
  page: number = 1;
  count: number = 0;
  tableSize: number = 7;
  constructor(private route: ActivatedRoute, private userService: UserService, private cartService: CartService, private router: Router) {
  }
  ngOnInit(): void {
    this.foodName = this.route.snapshot.params['name'];
    console.log(this.foodName);
    this.getDishByName();

  }

  getDishByName() {
    this.userService.getFoodByName(this.foodName).subscribe({
      next: (data) => {
        this.dish = data;
        this.dish.forEach((d) => {
          d.img = 'data:image/jpeg;base64,' + d.dishImage.imageData;
        })
      }, error: (error) => {
        console.log(error);
        alert('No Foods Found');
      }
    })
  }

  onTableDataChange(event: any) {
    this.page = event;
  }
  sortByPriceLowToHigh() {
    this.dish.sort((a, b) => a.price - b.price);
  }
  sortByPriceHighToLow() {
    this.dish.sort((a, b) => b.price - a.price);
  }
  sortByNameAscending() {
    this.dish.sort((a, b) => a.name.localeCompare(b.name));
  }
  sortByNameDescending() {
    this.dish.sort((a, b) => b.name.localeCompare(a.name));
  }

  addToCart(dish: Dish) {
    const cartItem = new CartItem(dish);
    this.cartService.addToCart(cartItem);
  }

}
