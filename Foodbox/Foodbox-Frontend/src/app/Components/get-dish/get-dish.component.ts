import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartItem } from 'src/app/cart-item';
import { Dish } from 'src/app/dish';
import { CartService } from 'src/app/Services/cart.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-get-dish',
  templateUrl: './get-dish.component.html',
  styleUrls: ['./get-dish.component.css']
})
export class GetDishComponent implements OnInit {
  cuisine!: string;
  dish!: Dish[];
  name!: string;
  page: number = 1;
  count: number = 0;
  tableSize: number = 7;
  constructor(private route: ActivatedRoute, private userService: UserService, private cartService: CartService, private router: Router) {

  }
  ngOnInit(): void {
    this.cuisine = this.route.snapshot.params['cuisine'];
    this.showFoodByCuisine();
  }

  onTableDataChange(event: any) {
    this.page = event;
  }



  showFoodByCuisine() {
    if (this.cuisine == 'All-Foods') {
      this.userService.getAllFood().subscribe({
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

    } else {
      this.userService.getFoodByCuisine(this.cuisine).subscribe({
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
  }

  onSearch(name: string) {
    if (name != undefined) {
      console.log('navigating to search url');
      let url = "/user/search/dish/" + name;
      this.router.navigateByUrl(url);
    } else {
      console.log('please enter a name');
    }
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
