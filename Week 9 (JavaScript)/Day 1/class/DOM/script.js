// console.dir(document)
// console.log(document.doctype)
// console.log(document.title)

let h1one = document.querySelector("h1")
console.log(h1one)
h1one.textContent = "Book Details"
h1one.style.background = 'lightblue'

let addButton = document.createElement('input')
addButton.setAttribute('value','Add Book')
addButton.setAttribute('type','button')


let tablesection = document.querySelector("#bookTable")
let divsection = document.querySelector("div")
divsection.insertBefore(addButton,tablesection)


addButton.addEventListener('click',()=>{
    let aname = document.querySelector("#author-name").value
    let bname = document.querySelector("#book-name").value

    let x = document.getElementById('bookTable').insertRow(-1)
    let y = x.insertCell(0)
    let z = x.insertCell(1)

    y.innerHTML = aname
    z.innerHTML = bname

    document.querySelector('#author-name').value = " "
    document.querySelector('#book-name').value = " "
    document.querySelector('#author-name').focus()
})

