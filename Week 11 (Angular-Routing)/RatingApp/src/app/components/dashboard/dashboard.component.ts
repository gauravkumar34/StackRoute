import { Component, OnInit } from '@angular/core';
import { MovieSearchApiService } from "src/app/services/movie-search-api.service";
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  

  constructor(private services:MovieSearchApiService) { }
  public ratings = ["1","2","3","4","5"];
  public moviename: string = '';
  public movie:any;
  public check:boolean = false;
  public myRating:string = '';

  ngOnInit(): void {
    this.checkMovie();
    this.SearchMovie();
  }
  SearchMovie() {
    this.services.GetMovie(this.moviename).subscribe(data => {
      this.movie= data;
    })
  }


  checkMovie():boolean {
    if(Object.keys(this.movie).length === 0 && this.movie.constructor === Object){
      return false;
    } else {
      return true;
    }
  }


  AddMovie() {
    let m = {
      title:this.movie.Title,
      year:this.movie.Year,
      released:this.movie.Released,
      director:this.movie.Director,
      actors:this.movie.Actors,
      plot:this.movie.Plot,
      country:this.movie.Country,
      boxOffice:this.movie.BoxOffice,
      myRating:this.myRating,
      poster:this.movie.Poster

    }
    
    this.services.AddMovie(m).subscribe(data => {
      this.SearchMovie();
    })
  }



  
}
