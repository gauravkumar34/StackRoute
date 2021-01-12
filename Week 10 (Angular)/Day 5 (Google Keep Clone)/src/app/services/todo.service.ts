import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) { }
  GetItems() {
    return this.http.get(`http://localhost:3000/notes`)
  }
  AddItem(item:any) {
    return this.http.post(`http://localhost:3000/notes`,item)
  }
  DeleteItem(id: number) {
    return this.http.delete(`http://localhost:3000/notes/${id}`)
  }
  AddItemTrash(item:any) {
    return this.http.post(`http://localhost:3000/trans`,item)
  }
  updateItem(id:number,item:any) {
    return this.http.put(`http://localhost:3000/notes/${id}`,item)
  }
  getAllTrashData() {
    return this.http.get(`http://localhost:3000/trans`)
  }
  DeleteFromTrash(id:number) {
    return this.http.delete(`http://localhost:3000/trans/${id}`)
  }
}
