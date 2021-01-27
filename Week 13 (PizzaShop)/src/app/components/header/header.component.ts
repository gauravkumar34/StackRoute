import { Component, OnInit, OnDestroy } from '@angular/core';
import { PizzaApiService } from 'src/app/services/pizza-api.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private services : PizzaApiService) {}
  public lenCart : any;

 

  getCart() {
    this.services.getCartItem().subscribe(data => {
      this.lenCart =  Object.keys(data).length;
      // this.getCart();
      
    })
    
    
  }
  ngOnInit(): void {
    this.getCart();
  }
  ngOnDestroy(){
    this.getCart();
  }
  
  
}
