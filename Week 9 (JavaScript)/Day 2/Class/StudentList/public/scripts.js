//code to fetch the data from the API asynchrounously
//by means of AJAX

//1. Create an XMLHTTPRequest Object

const httpRequest = new XMLHttpRequest()
console.log("after object creation")
console.log(httpRequest.readyState) // 0/1
//2. Configure the request using open()
httpRequest.open('GET','http://localhost:3000/students')
console.log("after open")
console.log(httpRequest.readyState) 
//3. send the request for processing
httpRequest.send()
//4. expect a response back
httpRequest.onreadystatechange=()=>{
    if(httpRequest.readyState==4)
    {
        console.log("Response recieved")

        console.log(httpRequest.response)
        resp = JSON.parse(httpRequest.response)
        console.log("After Parsing")
        console.log(resp)
        let ulhtml = ''
        resp.forEach(element => {
            ulhtml+=`<li>${element.id} :: ${element.studentName} :: ${element.studentMarks}`
            
        });

        document.getElementById('studentList').innerHTML = `<ul>${ulhtml}</ul>`

    }
}
console.log("fetch done")

console.log(httpRequest.readyState)
