import { Component, OnInit } from '@angular/core';
import { Note } from '../note';
import { NotesService } from '../services/notes.service';

@Component({
  selector: 'app-note-taker',
  templateUrl: './note-taker.component.html',
  styleUrls: ['./note-taker.component.css']
})
export class NoteTakerComponent implements OnInit{

  errMessage: string;
  note:Note = new Note();
  constructor(private services: NotesService) {
    this.note = new Note();
  }
  ngOnInit(): void {
  }

  
  public notes:Array<Note>;  //all notes are added in this array on click submit AddNote()  
  addNote() {
    if(!this.note.title || !this.note.text){
      this.errMessage = 'Title and Text both are required fields';
    }
    this.services.addNote(this.note).subscribe(data => {
      this.notes.push(this.note);
      this.note = new Note();
      this.errMessage = 'Unable to add the note to Notes';
    },err => {
      this.errMessage = err.message;
    })
  }
}
