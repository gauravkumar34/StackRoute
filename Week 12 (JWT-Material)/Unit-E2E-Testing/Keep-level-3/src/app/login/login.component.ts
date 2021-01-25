import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit {
  
  submitMessage:string;
  username = new FormControl();
  password = new FormControl();
  constructor (private services: AuthenticationService, private router:RouterService) {}  
  
  public loginForm = new FormGroup({
    username : this.username,
    password : this.password
  }) 
    ngOnInit(): void {
    }
    loginSubmit() {
      this.services.authenticateUser(this.loginForm.value).subscribe((data:any) =>{
        this.services.setBearerToken(data['token']);
        this.router.routeToDashboard();
      }, err => {
        this.submitMessage = err.message;
        if(err.status === 403) {
          this.submitMessage = err.error.message;
        } else{
          this.submitMessage = err.message;
        }
      })
    
  }



}
