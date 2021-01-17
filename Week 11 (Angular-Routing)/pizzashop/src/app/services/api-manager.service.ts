import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class ApiManagerService {

  constructor(private http:HttpClient) { }

  postPizzaApi(item:any) {
    return this.http.post(`http://localhost:3000/pizza`,item)
  }

  getPizzaApi(){
    return this.http.get(`http://localhost:3000/pizza`)
  }
}
