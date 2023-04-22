import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Dish } from 'src/app/dish';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-update-dish',
  templateUrl: './update-dish.component.html',
  styleUrls: ['./update-dish.component.css']
})
export class UpdateDishComponent {
  did!: number;
  dish: Dish = new Dish();
  isValid!: boolean;
  message!: string;
  constructor(private route: ActivatedRoute, private userService: UserService, private router: Router) {
    this.did = this.route.snapshot.params['did'];
    this.getDish();
  }

  getDish() {
    this.userService.findById(this.did).subscribe({
      next: (data) => {
        this.dish = data;
      }, error: (error) => {
        console.log(error);
      }
    })
  }

  updateDish() {
    this.userService.updateFood(this.did, this.dish).subscribe({
      next: (data) => {
        this.isValid = true;
        this.message = 'Food details updated successfully!';
      }, error: (error) => {
        this.isValid = false;
        this.message = 'Something went wrong!';
      }
    })
  }

  onClick() {
    this.router.navigate(['/admin/get/all/foods']);
  }




}
