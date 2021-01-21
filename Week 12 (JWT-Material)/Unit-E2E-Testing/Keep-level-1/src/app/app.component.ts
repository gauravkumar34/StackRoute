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
  constructor(private service:NotesService) {}
  note: Note = new Note();
  ngOnInit(): void {
    this.getNotes();
  }
  public notes:Array<Note>;
  getNotes() {
    this.service.getNotes().subscribe(data => {
        this.notes = data;
    }, error=>{
      this.errMessage =error.message;
    })
  }
  addNote() {
    if(!this.note.title || !this.note.text){
      this.errMessage ='Title and Text both are required fields';
      return;
    }
    this.service.addNote(this.note).subscribe(data => {
        this.notes.push(this.note);
        this.note = new Note();
        this.errMessage ='Unable to add the note to Notes';
    }, error => {
      this.errMessage=error.message;
    })}}