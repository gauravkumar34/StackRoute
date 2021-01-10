import { Component, Input, OnInit } from '@angular/core';
import movies from './_files/db.json'
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  public moviesList:{
    originalTitle:String,actors:String,poster:String,year:String,storyline:String
  }[] =movies;
  
  ngOnInit(){
  }
  
}
