import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PizzaApiService } from 'src/app/services/pizza-api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private services : PizzaApiService ) { }
  public pizzas :any;
  ngOnInit(): void {
    this.getData();
  }


  getData() {
    return this.services.getPizzaApi().subscribe(data=>{
      this.pizzas = data
    })
  }

  addItem(item:any) {
    let  items = {
      name: item.name,
      price: item.price,
      itemAdd:1
    }
    this.services.addItemToCart(items).subscribe(data => {
      alert('Item is Added')
    })
    
  }
}
