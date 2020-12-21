## Problem Statement: Find Total of a grocery cart including taxes using lambda expression

**Given a Map and Double find total purchase cost including taxes by iterating through the Map using lambda expression**

**This exercise contains a class named CartCheckout with the following method:**

     +billGenerator(Map<String, BigDecimal>, Double) : String  
         - Should take a Map and Double as input and return a String as result
         - Should validate the input Map by checking it is empty and return error String if it is empty     
         - Should return error String when Map contains null or empty or blank space as a value      
         - Should return error String when the Double is negative or null              


## Example
    Sample Input:
    {Apple=54, Grapes=36.78, Papaya=27.89, Orange=23.6, Banana=10.2}, 10.5     
    
    Expected Output:
    "168.47935"
--------------------------------------------------------
    Sample Input:
    {}, 13
        
    Expected Output:
    "The cart Map is empty"
--------------------------------------------------------
    Sample Input:
    {Apple=54, Grapes=36.78, Papaya=27.89, Orange=23.6, Banana=10.2}, -2.5
        
    Expected Output:
    "The taxPercent cannot be negative"
--------------------------------------------------------
    Sample Input:
    {Apple=54, Grapes=36.78, Papaya=27.89, Orange=23.6, Banana=10.2}, null
        
    Expected Output:
    "The taxPercent cannot be null"


## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding