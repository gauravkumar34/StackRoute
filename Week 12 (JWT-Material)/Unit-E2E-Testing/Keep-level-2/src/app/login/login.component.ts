import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  submitMessage: string;
  username = new FormControl();
  password = new FormControl();
  constructor(private service:AuthenticationService,private routerServices:RouterService){}

public loginForm = new FormGroup({
  username : this.username,
  password :  this.password
})
  ngOnInit(): void { 
    }
  loginSubmit() {
      this.service.authenticateUser(this.loginForm.value).subscribe((data:any) => {
        this.service.setBearerToken(data['token']);
        this.routerServices.routeToDashboard();
      },err => {
        this.submitMessage = err.message;
        if (err.status === 403) {
          this.submitMessage = err.error.message;
        } else {
          this.submitMessage = err.message;
        }
      })
    }    
}
