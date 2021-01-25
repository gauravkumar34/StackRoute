import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Note } from '../note';
import { NotesService } from '../services/notes.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-edit-note-view',
  templateUrl: './edit-note-view.component.html',
  styleUrls: ['./edit-note-view.component.css']
})
export class EditNoteViewComponent implements OnInit, OnDestroy {
  note: Note;
  states: Array<string> = ['not-started', 'started', 'completed'];
  errMessage: string;
  constructor(private noteService: NotesService,
    private routeService: RouterService,
    private dialogRef: MatDialogRef<EditNoteViewComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any) { }

  ngOnInit() {
    this.note = this.noteService.getNoteById(this.data);

  }
  ngOnDestroy() {
    this.routeService.routeBack();
  }

  onSave() {
    this.noteService.editNote(this.note).subscribe((editedNote) => {
      this.dialogRef.close();
    }, error => {
      this.errMessage = error.message;
    });
  }
}