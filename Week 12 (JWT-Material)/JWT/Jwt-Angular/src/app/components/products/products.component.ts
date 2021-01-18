import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private services:UserService) { }
  public products:any;
  ngOnInit(): void {
    this.getAllData();
  }
  getAllData() {
    this.services.getData().subscribe(data=>{
      this.products=data;
      console.log(data)
    })
  }
}
