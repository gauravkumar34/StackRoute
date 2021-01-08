import { Injectable } from '@angular/core';
import { zip } from 'rxjs';

@Injectable({  //service
  providedIn: 'root'
})
export class ContactService {

  constructor() { }

  Factorial(num: number) : Number{
    let fact =1;
    for(let i=1; i<=num;i++){
      fact = fact *  i;
    
    }
    return fact;
  }

  PrimeNumber(nums : number) : Boolean{

    let z = true;
    for(let i=2; i< nums;i++){

      if( nums %i === 0 ){
        z = false;
        break;
      } else {
        z = true;
      }
    }
    return z;
  }
}
