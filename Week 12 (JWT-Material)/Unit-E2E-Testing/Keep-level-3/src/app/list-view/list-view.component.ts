import { Component, OnInit } from '@angular/core';
import { Note } from '../note';
import { NotesService } from '../services/notes.service';

@Component({
  selector: 'app-list-view',
  templateUrl: './list-view.component.html',
  styleUrls: ['./list-view.component.css']
})
export class ListViewComponent  implements OnInit{

 
  constructor(private services:NotesService) {}
  ngOnInit(): void {
    this.getNotes();
  }
  notStartedNotes: Array<Note>;
  startedNotes: Array<Note>;
  completedNotes: Array<Note>;
  

  filterNotes(data:Array<Note>) {
    this.notStartedNotes = data.filter((note)=>note.state === 'not-started');
    this.startedNotes = data.filter((note)=> note.state === 'started');
    this.completedNotes = data.filter((note)=> note.state === 'completed')
  }

  getNotes() {
    this.services.getNotes().subscribe(data => {
      this.filterNotes(data);
    })
  }
}
