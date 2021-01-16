import { Component, OnInit } from '@angular/core';
import {MovieSearchApiService} from 'src/app/services/movie-search-api.service'
@Component({ 
  selector: 'app-search-movies',
  templateUrl: './search-movies.component.html',
  styleUrls: ['./search-movies.component.scss']
})
export class SearchMoviesComponent implements OnInit {

  constructor(private services: MovieSearchApiService) { }

  public myMovie:any;
  
  ngOnInit(): void {
    this.getMyMovie()
    this.getStar()
  }

  
  currentRate : any ;

  getMyMovie() {
    this.services.GetMyMovie().subscribe(data => {
      this.myMovie=data
      console.log(data)
    })
  }
  
  getStar(){
    let d = this.myMovie.myrating;
    console.log(d)
  }
  ratingDelete(id:number) {
    this.services.deleteMov(id).subscribe(data => {
      this.getMyMovie();
    })
  }

}
