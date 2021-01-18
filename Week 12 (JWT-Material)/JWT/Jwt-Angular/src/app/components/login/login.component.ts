import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')
  })
  constructor(private services:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  LoginUser() {
    this.services.login(this.loginForm.value).subscribe((data:any)=> {
      localStorage.setItem('token',data.access_token)
      console.log("logIn")
      this.reDirect();
      
    });
  }

  

  reDirect() {
    this.router.navigate(['/'])
  }
  

}
