import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http:HttpClient) { }

  GetContacts() {
    return this.http.get('http://localhost:3000/contacts')
  }
  AddContact(item:any) {
    return this.http.post(`http://localhost:3000/contacts`,item)
  }
  DeleteCont(id:number) {
    return this.http.delete(`http://localhost:3000/contacts/${id}`);
  }
  UpdateCont(item:any ,id:number) {
    return this.http.put(`http://localhost:3000/contacts/${id}`,item)
  }
}
