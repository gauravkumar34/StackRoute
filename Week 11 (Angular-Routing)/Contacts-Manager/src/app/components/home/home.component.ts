import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactService } from "src/app/services/contact.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private services : ContactService, private router: Router) { }

  ngOnInit(): void {
    this.getAllContact();
  }

  public allContacts:any;
  getAllContact() {
    this.services.GetContacts().subscribe(data => {
      this.allContacts = data;
    })
  }
  DeleteContact(item: any) {
    this.services.DeleteCont(item.id).subscribe(data => {
      this.getAllContact();
    })
  }

  reDirectEditPage(item:any) {
    this.router.navigate(['/edit-contact',item])
  }

}
