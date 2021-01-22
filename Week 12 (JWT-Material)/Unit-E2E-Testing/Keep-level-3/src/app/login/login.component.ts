import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit {
    constructor (private services: AuthenticationService, private router:RouterService) {}  
  ngOnInit(): void {
    }
    public submitMessage:string;
    username = new FormControl();
    password = new FormControl();

    public loginFrom = new FormGroup({
      username : this.username,
      password : this.password
    }) 

    loginSubmit() {
      this.services.authenticateUser(this.loginFrom).subscribe((data:any) =>{
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
