import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor() { }
  public name:String = "Gaurav";
  public isDisabled: Boolean = false;
  public myStyle = {
    'color-red':true,
    'text-style':true
  };
  public hasError:Boolean = true;

  public style1 = {
    color:'Green',
    fontStyle:'italic',
    fontFamily:'Comic Sans MS'
  }

  public username: String= '';

  ngOnInit(): void {
  }

  onCLickHandler() {
    console.log(`Welcome bhai Jaan Ji `+this.username)
  }
}
