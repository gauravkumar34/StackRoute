import { Component, Input, OnInit, Output ,EventEmitter, inject} from '@angular/core';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contactlist',
  templateUrl: './contactlist.component.html',
  styleUrls: ['./contactlist.component.css']
})
export class ContactlistComponent implements OnInit {

  @Input('parentComponentData') public username : String ='';
  @Output() public myEvent = new EventEmitter();
  public result:any; 
  public results:any;
  constructor(private services : ContactService) { }
  ngOnInit(): void {
    // console.log(this.services.Factorial(5))
  }
  onCalculate(value: string) {
     this.result =this.services.Factorial(parseInt(value))
  }
  onCalculateP(value: string) {
    this.results = this.services.PrimeNumber(parseInt(value))
  }
  sendData(){
    this.myEvent.emit('Welcome Gaurav')
  }
}
