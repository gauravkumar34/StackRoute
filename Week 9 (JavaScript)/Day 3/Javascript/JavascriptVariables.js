//variables in JS

var a;
//console.log(a)//undefined --> hoisting --> declarations are pulled up
 a = 10;
// a = "string"; //last value of a
 console.log(a)

// let, const


if(true)
{
    let a = 20;
    console.log("inside if : "+a)
}

console.log(a)


let employee ={"empid":101,"empname":"Gary"}

console.log(employee)


//Template Strings

let x = 10;
let y = 20;

var product = x*y

console.log("Product of "+x+" and "+y+" is "+product);

console.log(`Product of ${x} and ${y} is ${product}`)

console.log(`Sum of ${x} and ${y} is ${x+y}`)




//functions

function taxCalculator(category,name,price)
{
    var totPrice = 0.0;
    if(category=="mobile")
    {
        totPrice = (12.5/100)*price+price;
    }
    if(category=="books")
    {
    totPrice = (7.5/100)*price+price;
    }
    if(category=="clothes")
    {
        totPrice = (10.5/100)*price+price;
    }

    return totPrice
}

var calculatedPrice = taxCalculator("mobile","Raj",10000)
console.log(calculatedPrice)


//function as an expression

let sum = function add(a,b){
    return a+b
}

console.log(sum(10,8))

//passing a function as an expression, higher order function

// y = x^2 + x^3 --> 

function square(n){
    return n*n
}
function cube(n){
    return n*n*n
}

function equation(func1,func2,x){
    return func1(x)+func2(x)
}

console.log(equation(square,cube,5))


y = equation(function square(n){
    return n*n
},function cube(n){
    return n*n*n
},5)
console.log(y)

//fat arrow notation

z = equation(n=>n*n,n=>n*n*n,5)

console.log(z)



let strArr = ['this','is','a','great','day','a','the','this','that','top']
console.log(strArr)

for(i = 0;i<strArr.length;i++)
{
    console.log(strArr[i])
}

//builtin functions

strArr.push("Good")
console.log(strArr)
strArr.unshift("Morning")
console.log(strArr)
strArr.pop()
console.log(strArr)
strArr.shift()
console.log(strArr)


let pos = strArr.indexOf("a");
console.log(pos)

//remove an element at a given index

strArr.splice(pos,1) 
console.log(strArr)

strArr.splice(2,0,"are")
console.log(strArr)



//filter,map,reduce -

//iterate through the array -> perform a computation -> result

//forEach

strArr.forEach((s)=>console.log(s))
//map
strArr.map(s=>s.toUpperCase()).forEach((x)=>console.log(x))

//filter

strArr.filter(s=>s.startsWith('t')).map((s)=>s.toUpperCase()).forEach(s=>console.log(s))

//reduce -> reduces the values of an array to just one values

let count = 0;

count = 
strArr.map(s=>s.toUpperCase()).filter(s=>s.startsWith('T')).reduce((count,s)=>{return ++count},count)
//t -> 
console.log(count)


var pets =['dog','cat','dog','chicken','hamster']

//count the no of words in the array

var petCounts = pets.reduce(function(arr,pet){
    if(!arr[pet]){
        arr[pet] = 1;}
       else{
           arr[pet]++;
       }
       return arr;
    },{});
console.log(petCounts)