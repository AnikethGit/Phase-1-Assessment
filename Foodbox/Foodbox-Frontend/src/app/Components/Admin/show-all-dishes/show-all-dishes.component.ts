import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Dish } from 'src/app/dish';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-show-all-dishes',
  templateUrl: './show-all-dishes.component.html',
  styleUrls: ['./show-all-dishes.component.css']
})
export class ShowAllDishesComponent {

  constructor(private userService: UserService, private router: Router) {
    this.getAllDishes();
  }
  dish!: Dish[];
  foodName!: string;
  prod: Dish = new Dish();
  page: number = 1;
  count: number = 0;
  tableSize: number = 7;
  event: any;

  onTableDataChange(event: any) {
    this.page = event;
  }

  getAllDishes() {
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
  }
  getDishByName() {
    this.onTableDataChange(this.event);
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

  getDishByCuisine(category: string) {
    this.onTableDataChange(this.event);
    this.userService.getFoodByCuisine(category).subscribe({
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

  deleteDish(did: number) {
    this.userService.deleteFood(did).subscribe({
      next: (data) => {
        this.getAllDishes();
      }, error: (error) => {
        console.log(error);
      }
    })
  }
  updateDish(did: number) {
    let url = "/admin/update/food/" + did;
    this.router.navigateByUrl(url);
  }
  onClick() {
    window.location.reload();
  }
  onActivate(did: number, d: Dish) {
    this.prod = d;
    this.userService.setAvailable(did, this.prod).subscribe({
      next: (data) => {

      }, error: (error) => {
        console.log(error);
      }
    })
  }
}
