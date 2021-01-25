import { Component, OnInit } from '@angular/core';
import { Note } from '../note';
import { NotesService } from '../services/notes.service';

@Component({
  selector: 'app-list-view',
  templateUrl: './list-view.component.html',
  styleUrls: ['./list-view.component.css']
})
export class ListViewComponent  implements OnInit{

  notStartedNotes: Array<Note>;
  startedNotes: Array<Note>;
  completedNotes: Array<Note>;
  constructor(private services:NotesService) {
    this.notStartedNotes = [];
    this.startedNotes = [];
    this.completedNotes = [];
  }
  
  

  filterNotes(data:Array<Note>) {
    this.notStartedNotes = data.filter((note)=>note.state === 'not-started');
    console.log(this.notStartedNotes)
    this.startedNotes = data.filter((note)=> note.state === 'started');
    console.log(this.startedNotes)
    this.completedNotes = data.filter((note)=> note.state === 'completed')
    console.log(this.completedNotes)
  }
  ngOnInit(){
    this.getNotes();
  }
  
  getNotes() {
    this.services.getNotes().subscribe(data => {
      this.filterNotes(data);
      
    }, err => {});
  }
}
