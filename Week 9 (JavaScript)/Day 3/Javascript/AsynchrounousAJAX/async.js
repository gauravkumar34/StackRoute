function greet()
{
    dayGreeting()
    setTimeout(()=>{console.log("Have a good day")},3000)
    eveningGreeting()
}

function dayGreeting()
{
    console.log("Good Morning")
}

function eveningGreeting()
{
    console.log("Good Evening")
}
console.log("End of greeting")
greet()
