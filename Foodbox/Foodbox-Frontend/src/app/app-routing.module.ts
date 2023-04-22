import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './Components/admin-login/admin-login.component';
import { AddDishComponent } from './Components/Admin/add-dish/add-dish.component';
import { AdminDashboardComponent } from './Components/Admin/admin-dashboard/admin-dashboard.component';
import { AllOrdersComponent } from './Components/Admin/all-orders/all-orders.component';
import { ShowAllDishesComponent } from './Components/Admin/show-all-dishes/show-all-dishes.component';
import { UpdateDishComponent } from './Components/Admin/update-dish/update-dish.component';
import { CartDetailsComponent } from './Components/cart-details/cart-details.component';
import { GetDishComponent } from './Components/get-dish/get-dish.component';
import { HomeComponent } from './Components/home/home.component';
import { SearchDishComponent } from './Components/search-dish/search-dish.component';
import { UserLoginComponent } from './Components/user-login/user-login.component';
import { UserSignupComponent } from './Components/user-signup/user-signup.component';
import { AllUserOrdersComponent } from './Components/User/all-user-orders/all-user-orders.component';
import { OrderConfirmationComponent } from './Components/User/order-confirmation/order-confirmation.component';
import { OrderDetailsComponent } from './Components/User/order-details/order-details.component';
import { UserHomeComponent } from './Components/User/user-home/user-home.component';
import { AdminGuard } from './Services/admin.guard';
import { UserGuard } from './Services/user.guard';

const routes: Routes = [
{ path: 'user/login', component: UserLoginComponent, pathMatch: 'full', title: 'User Login' },
{ path: 'admin/login', component: AdminLoginComponent, pathMatch: 'full', title: 'Admin Login' },
{ path: '', component: HomeComponent, pathMatch: 'full', title: 'Foodbox' },
{ path: 'user-home', component: UserHomeComponent, canActivate: [UserGuard], pathMatch: 'full', title: 'Home' },
{ path: 'admin-dashboard', component: AdminDashboardComponent, canActivate: [AdminGuard], pathMatch: 'full', title: 'Admin Dashboard' },
{ path: 'user/signup', component: UserSignupComponent, pathMatch: 'full', title: 'User Registration' },
{ path: 'admin/add-food', component: AddDishComponent, canActivate: [AdminGuard], pathMatch: 'full', title: 'Add Food' },
{ path: 'admin/get/all/foods', component: ShowAllDishesComponent, canActivate: [AdminGuard], pathMatch: 'full', title: 'All Foods' },
{ path: 'admin/update/food/:did', component: UpdateDishComponent, canActivate: [AdminGuard], pathMatch: 'full', title: 'Update Food' },
{ path: 'user/search/dish/:name', component: SearchDishComponent, pathMatch: 'full', title: 'Search results' },
{ path: 'show/dish/class/:cuisine', component: GetDishComponent, pathMatch: 'full', title: 'All Dishes' },
{ path: 'get/all/class/:cuisine', component: GetDishComponent, pathMatch: 'full', title: 'All Dishes' },
{ path: 'get/cart/details', component: CartDetailsComponent, pathMatch: 'full', title: 'Cart Details' },
{ path: 'user/create/order', component: OrderDetailsComponent, canActivate: [UserGuard], pathMatch: 'full', title: 'Order Details' },
{ path: 'order-confirmation/invoice/:oid', component: OrderConfirmationComponent, canActivate: [UserGuard], pathMatch: 'full', title: 'Order Confirmation' },
{ path: 'admin/all/user-orders', component: AllOrdersComponent, canActivate: [AdminGuard], pathMatch: 'full', title: 'All Orders' },
{ path: 'order/details/:oid', component: OrderConfirmationComponent, canActivate: [AdminGuard], pathMatch: 'full', title: 'Order Details' },
{ path: 'user/get/all-orders/:username', component: AllUserOrdersComponent, canActivate: [UserGuard], pathMatch: 'full', title: 'Orders Placed' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
