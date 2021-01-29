import { Component, OnInit } from '@angular/core';
import { PizzaApiService } from 'src/app/services/pizza-api.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private services :PizzaApiService) { }
  public datas :any;
  public totals :any;
  public gstTotals :any;
  public totalAmount :any;
  ngOnInit(): void {
    this.getCart()
  }

  quantity:number=1;
  i=1;
  plus() {
    if(this.i !=5 ){
      this.i++;
      this.quantity=this.i;
    }
  }
  minus() {
    if(this.i != 1) {
      this.i--;
      this.quantity=this.i;
    }
  }
  getCart() {
    return this.services.getCartItem().subscribe(data => {
      this.datas = data;
      this.getAllAmount();
      this.getGst();
    })
  }

  deleteItem(item:any){
    return this.services.deleteItemCart(item.id).subscribe(data => {
      this.getCart();
    })
  }
  getAllAmount() {
    var total=0
    this.datas.forEach(element => {
      total += element.price;
    });
    return this.totals = total;
  }
  getGst() {
     this.gstTotals = (5*this.totals)/100;
     this.totalAmount = this.totals + this.gstTotals;
    
  }

}
