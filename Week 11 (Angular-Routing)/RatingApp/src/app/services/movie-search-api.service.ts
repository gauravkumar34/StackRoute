import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class MovieSearchApiService {

  constructor(private http:HttpClient) { }

  GetMovie(name: string) {
    return this.http.get(`http://www.omdbapi.com/?apikey=8266bbff&t=${name}`)
  }

  AddMovie(item:any){
    return this.http.post(`http://localhost:3000/movies`,item)
  }

  
  GetMyMovie() {
    return this.http.get(`http://localhost:3000/movies`)
  }
  deleteMov(id:number) {
    return this.http.delete(`http://localhost:3000/movies/${id}`)
  }
}
