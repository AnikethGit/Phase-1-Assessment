import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderDetails } from '../order-details';
import { Dish } from '../dish';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  baseUrl = 'http://localhost:8080';

  public userSignUp(user: User): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/user/signup`, user);
  }

  public addFood(dish: Dish, image: Blob): Observable<any> {
    let formData = new FormData();
    formData.append('dish', JSON.stringify(dish));
    formData.append('image', image);
    return this.http.post<any>(`${this.baseUrl}/add/dish`, formData);
  }

  public getAllFood(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/get/all-dishes`);
  }

  public getFoodByName(name: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/get/dishes/${name}`);
  }

  public getFoodByCuisine(cuisine: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/get/dishes-by-cuisine/${cuisine}`);
  }

  public deleteFood(did: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/delete/dish/${did}`);
  }

  public findById(did: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/get-dish/${did}`);
  }

  public updateFood(did: number, dish: Dish): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/update/dish/${did}`, dish);
  }

  public setAvailable(did: number, dish: Dish): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/set-availability/dish/${did}`, dish);
  }

  public createOrder(orderDetails: OrderDetails): Observable<OrderDetails> {
    return this.http.post<OrderDetails>(`${this.baseUrl}/user/create/order`, orderDetails);
  }

  public getOrderById(oid: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/get/order-invoice/${oid}`);
  }

  public getAllOrders(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/get/all/orders`);
  }

  public deleteOrder(oid: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/delete/order/${oid}`);
  }

  public getOrderByUsername(username: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/get/orders/${username}`);
  }


}
