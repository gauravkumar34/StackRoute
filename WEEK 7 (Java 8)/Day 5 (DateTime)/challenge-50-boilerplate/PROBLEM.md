## Problem Statement: Concatenate String using Optional to avoid NullPointerException and null checks in code  ##

**Given 2 strings, convert them to optional type and concatenate strings**

**This exercise contains a class named OptionalDemo with the following method:**

    +concatenateString(String inputOne, String inputTwo) : String 
        -Should accept 2 input strings and return a string
        -Should convert 2 input strings to Optional type using Optional.ofNullable
        -Should check for first parameter, if present then get the string values and concatenate strings.
        -Should return "Cannot concatenate with null string" if first parameter is null

## Example
    Sample Input:
    string1 = stack
    string2 = route
    
    Expected Output:
    stackroute   
--------------------------------------------------------
    Sample Input:
    string1 = null
    string2 = route
    
    Expected Output:
    Cannot concatenate with null string

    
## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding