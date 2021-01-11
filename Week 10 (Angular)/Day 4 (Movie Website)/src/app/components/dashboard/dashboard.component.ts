import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MoviesService } from "src/app/services/movies.service";
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private services : MoviesService) { }

  public getMovies : any;
  public getMovieName :string ='';
  public getFavmovs : any;
  ngOnInit(){
    this.GetAllMovies();
    this.GetAllFav();
  }

  GetAllMovies() {
    this.services.GetMovies().subscribe(data => {
      this.getMovies = data;
    })
  }

  GetAllFav() {
    this.services.GetFavMovies().subscribe(data => {
      this.getFavmovs = data;
    })
  }

  AddTofav(item:any) {
 
    this.services.AddFavorite(item).subscribe(data => {
      console.log(item)
      this.GetAllFav();
    })
  }

  DeleteFromFav(item:any) {
    this.services.DeleteFav(item.id).subscribe(data => {
      this.GetAllFav();
    })
  }

  onChange(item: any) {
    item.watched = item.watched ? false : true;
    this.services.UpdateItem(item.id, item).subscribe(data => {
      this.GetAllFav();
    })
  }

}
