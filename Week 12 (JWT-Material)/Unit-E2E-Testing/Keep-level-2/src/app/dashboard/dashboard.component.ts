import { Component, OnInit } from '@angular/core';
import { Note } from '../note';
import { NotesService } from '../services/notes.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  constructor(private service:NotesService) {}
  errMessage: string;
  note: Note = new Note();
  public notes:Array<Note>;
  ngOnInit(): void {
    this.getNotes();
  }
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
    }
    )
  }
}
