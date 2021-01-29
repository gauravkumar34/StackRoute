import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { PizzaApiService } from 'src/app/services/pizza-api.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private modalService: NgbModal, private services : PizzaApiService) {}

  public lenCart:number;
  closeResult = '';
  ngOnInit(): void {
    this.getCartLen()
  }
  
  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;

    })
  }

  getCartLen() {
     this.services.getCartItem().subscribe(data => {
      this.lenCart = Object.keys(data).length
    })
  }
}
