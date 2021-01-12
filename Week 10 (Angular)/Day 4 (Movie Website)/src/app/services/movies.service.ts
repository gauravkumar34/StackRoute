import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(private http: HttpClient) { }

  GetMovies()  {
    return this.http.get(`http://localhost:3000/movieList`)
  } 

  GetCategories() {
    return this.http.get(`http://localhost:3000/categories`)
  }

  GetFavMovies()  {
    return this.http.get(`http://localhost:3000/favorites`)
  } 
 
  AddFavorite(item: any) {
    return this.http.post(`http://localhost:3000/favorites`,item)
  }

  DeleteFav(id : number) {
    return this.http.delete(`http://localhost:3000/favorites/${id}`);
  }
  
  UpdateItem(id:number, item: any) {
    return this.http.put(`http://localhost:3000/favorites/${id}`,item)
  }

  
}
