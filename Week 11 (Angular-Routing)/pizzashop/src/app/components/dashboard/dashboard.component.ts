import { Component, OnInit } from '@angular/core';
import {FormGroup , FormControl, FormBuilder} from '@angular/forms'
import {ApiManagerService}  from 'src/app/services/api-manager.service'
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  PizzaInputsForm : FormGroup;
  constructor(private formBuilder:FormBuilder, private services:ApiManagerService) { 
    this.PizzaInputsForm = formBuilder.group({
    pizzaName: new FormControl(),
    pizzaPrice: new FormControl(),
    pizzaPic: new FormControl()
    })
  }
  public pizzas :any;

  ngOnInit(): void {
    this.getData();
  }

  postData() {
    return this.services.postPizzaApi(this.PizzaInputsForm.value).subscribe(data =>{
      this.getData();
    })
  }
  getData() {
    return this.services.getPizzaApi().subscribe(data=>{
      this.pizzas = data
    })
  }

}
