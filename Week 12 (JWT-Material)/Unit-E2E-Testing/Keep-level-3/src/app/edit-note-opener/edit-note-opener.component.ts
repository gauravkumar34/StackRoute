import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { EditNoteViewComponent } from '../edit-note-view/edit-note-view.component';
@Component({
  selector: 'app-edit-note-opener',
  templateUrl: './edit-note-opener.component.html',
  styleUrls: ['./edit-note-opener.component.css']
})
export class EditNoteOpenerComponent {
  constructor(private dialog: MatDialog,
    private activatedRoute: ActivatedRoute) {
    const noteId = this.activatedRoute.snapshot.paramMap.get('noteId');
    const editDialog = this.dialog.open(EditNoteViewComponent, {
    data :noteId
});
}
}
