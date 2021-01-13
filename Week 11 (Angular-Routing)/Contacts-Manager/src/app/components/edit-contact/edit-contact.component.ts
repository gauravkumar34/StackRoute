import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContactService } from 'src/app/services/contact.service'
@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent implements OnInit {

  constructor(private services: ContactService, private route: ActivatedRoute,private router:Router) { }
  

  
  ngOnInit(): void {
    this.getContact()
  }
  public name:any;
  public email:any;
  public pnumber:any;
  public id:any;
  getContact() {
    this.route.params.subscribe(p=>{
      this.name = p.name;
      this.email = p.email;
      this.pnumber = p.number;
      this.id = p.id;
    })
  }

  updateContact() {
    let item={
      id:this.id,
      name:this.name,
      email:this.email,
      number:this.pnumber

    }
    this.services.UpdateCont(item, item.id).subscribe(data => {
      this.router.navigate(['/home'])
    })
  }


}
