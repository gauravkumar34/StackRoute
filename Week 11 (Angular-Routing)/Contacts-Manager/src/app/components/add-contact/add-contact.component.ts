import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ContactService} from 'src/app/services/contact.service'
@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {

  constructor(private services : ContactService, private router:Router) { }

  ngOnInit(): void {
    
  }
  public name:string='';
  public email:string='';
  public pnumber:string='';

  AddContact() {
    let item = {
      name: this.name,
      email:this.email,
      number:this.pnumber
    }
    if(item.name.length === 0 && item.email.length ===0 && item.number.length ===0 ){
      alert("fuyshajfl;sklf");
      window.location.reload();
    }else {
      this.services.AddContact(item).subscribe(data => {
        this.redirect();
      })
    }
  }
  redirect() {
    this.router.navigate(['/home'])
  }
  

}
