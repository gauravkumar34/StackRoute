import { Component, OnInit } from '@angular/core';
import category from './_files/category.json'
@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  public categoryList:{
    name:String[] 
  }= category;
  
}
