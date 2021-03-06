import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class PizzaApiService {

  constructor(private http :HttpClient) { }
  // public lenCart:number;
  getPizzaApi(){
    return this.http.get(`http://localhost:3000/Products`);
  }
  addItemToCart(item:any) {
    return this.http.post(`http://localhost:3000/Cart`,item);
  }
  getCartItem() {
    return this.http.get(`http://localhost:3000/Cart`)
  }
  deleteItemCart(id:number) {
    return this.http.delete(`http://localhost:3000/Cart/${id}`);
  }

  // getCartLen() {
  //   return this.http.get(`http://localhost:3000/Cart`).subscribe(data => {
  //     this.lenCart = Object.keys(data).length;
  //   })
  // }

  
}
