import { Component, OnInit } from '@angular/core';
import { NotesService } from '../services/notes.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  ngOnInit(): void {
  }
  constructor(private service:NotesService) {
    this.getNotes();
  }

  getNotes() {
    this.service.fetchNotesFromServer();
  }

}
