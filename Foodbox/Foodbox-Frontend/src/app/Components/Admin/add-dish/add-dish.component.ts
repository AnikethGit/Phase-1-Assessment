import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Dish } from 'src/app/dish';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-add-dish',
  templateUrl: './add-dish.component.html',
  styleUrls: ['./add-dish.component.css']
})
export class AddDishComponent {
  constructor(private userService: UserService, private router: Router) { }

  dish: Dish = new Dish();
  file!: Blob;
  isValid!: boolean;
  message!: string;

  onSubmit() {
    this.userService.addFood(this.dish, this.file).subscribe({
      next: (response) => {
        this.isValid = true;
        this.message = "Food added successfully!"

      }, error: (error) => {
        this.isValid = false;
        this.message = 'Something went wrong!'
      }
    })
  }

  onChangeFileField(event: any) {
    this.file = event.target.files[0];
  }

  onClick() {
    this.router.navigate(['/admin-dashboard']);
  }
}
