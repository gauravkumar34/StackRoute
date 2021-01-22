import { Injectable, OnInit } from '@angular/core';
import { Note } from '../note';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do'
import 'rxjs/add/Observable/from'

@Injectable()
export class NotesService implements OnInit {
  
  notes: Array<Note>;
  notesSubject: BehaviorSubject<Array<Note>>;
  constructor(private http:HttpClient, private services:AuthenticationService){
    this.notes = [];
    this.notesSubject = new BehaviorSubject([]);
  }
  ngOnInit(): void {
  }
  
  fetchNotesFromServer() {
    this.http.get(`http://localhost:3000/api/v1/notes`,{ 
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.services.getBearerToken()}`)
    }).subscribe((res:any) => {
      this.notes = res;
      this.notesSubject.next(this.notes);
    }, (err:any) =>{
      this.notesSubject.error(err);
    })
  }

  getNotes(): BehaviorSubject<Array<Note>> {
   return this.notesSubject;
  }

  addNote(note: Note): Observable<Note> {
    return this.http.post<Note>(`http://localhost:3000/api/v1/notes`,note,{
      headers:new HttpHeaders().set('Authorization',`Bearer ${this.services.getBearerToken()}`)
    }).do(data => {
      this.notes.push(data);
      this.notesSubject.next(this.notes);
    });
  };

  editNote(note: Note): Observable<Note> {
    return this.http.put<Note>(`http://localhost:3000/api/v1/notes/${note.id}`,note,{
      headers: new HttpHeaders().set('Authorization',`Bearer ${this.services.getBearerToken()}`)
    }).do(data=> {
      // not done....
    })
  } 

  getNoteById(noteId): Note {
    return this.notes.find(note => note.id === Number(noteId))
  }
}
