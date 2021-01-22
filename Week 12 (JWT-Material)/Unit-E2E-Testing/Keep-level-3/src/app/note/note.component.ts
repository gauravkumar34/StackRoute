import { Component } from '@angular/core';
import { Note } from '../note';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent {
  constructor(private router:RouterService) {}
  note:Note
  editNote() {
    this.router.routeToEditNoteView(this.note.id);
  }
}
