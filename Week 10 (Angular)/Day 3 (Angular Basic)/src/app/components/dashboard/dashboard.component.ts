import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor() { }
  public isLoggedIn = false;
  public day = 7;
  public countries = ['India','China','Australia','America','Nepal','UAE']
  public persons = 
    [{
      id: 1, fName : "gaurav", lname : "Kumar", Image : 'assets/Images/gaurav.jpg'
    },{
      id: 2, fName : "saurav", lname : "Kumar",  Image : 'assets/Images/saurav.jpg'
    },{
      id:3, fName:"Nidhi",lname:"Kumari" ,  Image : 'assets/Images/nidhi.jpg'
    }]
  
  ngOnInit(): void {
  }

  onCLickHandler(element: any) {
    console.log(element)
  }
}
