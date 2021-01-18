import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public registerForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')
  })
  constructor(private services:UserService, private router:Router) { }

  ngOnInit(): void {
  }
  RegisterUser() {
    this.services.resgister(this.registerForm.value).subscribe(data=>{
      console.log(data)
      this.reDirect();
    })
  }
  reDirect() {
    this.router.navigate(['/login'])
  }
}
