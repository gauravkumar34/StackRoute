import { Component, OnInit } from '@angular/core';
import { MoviesService } from "src/app/services/movies.service";
@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {

  constructor(private services : MoviesService) { }

  ngOnInit(): void {
    this.GetAllCategories();
  }
  public getcategory;
  
  GetAllCategories() {
    this.services.GetCategories().subscribe(data => {
      this.getcategory = data;
    })
  }
}
