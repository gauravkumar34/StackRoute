
let strArr = ['this','is','a','great','day',"total"]
console.log(strArr)


for(i =0; i<strArr.length;i++){
    console.log(strArr[i])
}

strArr.push("gaurav");
console.log(strArr)
strArr.unshift("Morning");
console.log(strArr)
strArr.pop()
console.log(strArr)

strArr.shift()
console.log(strArr)

let pos = strArr.indexOf("a")
console.log(pos)

strArr.splice(pos,1)
console.log(strArr)

strArr.splice(2,0,"hoiney")
console.log(strArr)

//filter, map, reduce

//iterate through the array -> persorm a computation -> result 

//forEach 

strArr.forEach((s)=>console.log(s))

strArr.map(s=>s.toUpperCase()).forEach((x)=>console.log(x))

strArr.filter(s=>s.startsWith('t')).map((s)=>s.toUpperCase()).forEach(s=>console.log(s))

//reduce -> reduces the value of an array to just one values

let count =0;

count = strArr.map(s=>s.toUpperCase()).filter(s=>s.startsWith("T")).reduce((count,s)=>{return ++count},count)

console.log(count)


var pets = ['dogs','cat','dog','chicken','hamstar']

var petCount = pets.reduce(function(arr,pet){
    if(!arr[pet]){
        arr[pet] = 1;
    } else {
        arr[pet]++;
    }
    return arr;
},{});
console.log(petCount);