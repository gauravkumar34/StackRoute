function taxCalculate(category,name,price) {
    var totPrice = 0.0;
    if(category==="mobile"){
        totPrice = (12.5/100)*price + price;
    }
    if(category==="books"){
        totPrice = (7.5/100)*price + price;

    }
    if(category==="cloths"){
        totPrice = (10.5/100)*price + price;
    }
    return totPrice;
}

var calculatedPrice = taxCalculate("mobile","RAj",10000)
console.log(calculatedPrice);

//!lambda Expression */

z = equation((n)=>n*n,(n)=>n*n*n,5)
// z=0;
console.log(z);

