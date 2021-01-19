import { Component, OnInit } from '@angular/core';
import { NotesService } from './notes.service';
import { Note } from './note';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  
  errMessage: string;

  constructor(private serives:NotesService) {}
  note: Note = new Note(); 
  ngOnInit(): void {
    this.getNotes();
  }
  public notes:Array<Note>;
  getNotes() {
    this.serives.getNotes().subscribe(data => {
      if(data){
        this.notes = data;
      } else {
        this.errMessage='Unable to Retrive Data'
      }
    }, error=>{
      this.errMessage ='Http failure response for http://localhost:3000/notes: 404 Not Found'
    })
  }
  addNote() {
    if(!this.note.title || !this.note.text){
      this.errMessage ='Title and Text both are required fields'
      return;
    }

    this.serives.addNote(this.note).subscribe(data => {
      if(data){
        this.notes.push(this.note);
        this.note = new Note();
      } else{
        this.errMessage ='Unable to add the note to Notes'
      }
    }, error => {
      this.errMessage='Http failure response for http://localhost:3000/notes: 404 Not Found'
    })
  }
}