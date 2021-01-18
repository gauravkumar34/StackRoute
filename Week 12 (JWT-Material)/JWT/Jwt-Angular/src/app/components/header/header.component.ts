import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private services:UserService,private route:Router) { }

  ngOnInit(): void {
  }

  logOut() {
    localStorage.removeItem('token')
    this.redirect();
    console.log("logout")
  }

  redirect() {
    this.route.navigate(['/login'])
  }
}
