## Problem Statement - Calculator
_______________

Design a calculator application that will perform mathematical and scientific calculations.
Listed below are the basic operations done on a mathematical and scientific calculator

> **Basic Mathematical Operations**
1.	Addition of Integers and Decimal numbers
2.	Subtraction of Integers and Decimal numbers
3.	Multiplication of Integers and Decimal numbers
4.	Division of Integers and Decimal numbers
a.	Make sure that a number is not divided by zero, handle the situations appropriately.
5.	Modulo of Integers and Decimal numbers
> **Scientific calculations**
1.	Compute the ceil value
    - If the value entered is 0 or negative, raise an alert
2.	Compute the floor value number
    -  If the value entered is 0 or negative, raise an alert
3.	Square root of a non-negative number
    - Note that all the numbers taken as input must be non-negative. If value entered is 0 or negative, raise an alert and handle the situation. 
4.	Compute an exponential expression
    - The base and exponent must be a non-negative number 
    - The base and exponent must not be a zero
    >Sample Input

        Enter the operation you wish to perform : 
        1. Mathematical Calculation 
        2. Scientific Calculation 
        3. Exit

    >If user selects 1 the below menu must be displayed

        Select an arithmetic operation : 
        1. Add 
        2. Subtract 
        3. Multiply 
        4. Divide 
        5. Modulo 
        6. Back to Main Menu

    >If user selects 2 the below menu must be displayed

        Select a scientific operation : 
        1. Ceil 
        2. Floor 
        3. Square Root 
        4. Power Of 
        5. Back to Main Menu

    *Note that the menu must exit only if the user expilicitly exits, else it must prompt the user for input*

    >Sample Output/Input

        Enter the numbers a and b: 
        23
        56
        The sum of 23.0 and 56.0 is : 79.0

        Enter a non negative integer : 
        3
        Enter a non negative integer : 
        4
        The value of 3 to the power 4 is 81

>Handling exception situations sample input and output

        Enter a decimal number : 
        0
        The number is zero
        calculator.CalculatorException
        Enter the operation you wish to perform : 
        1. Mathematical Calculation 
        2. Scientific Calculation 
        3. Exit
            at calculator.ScientificCalculator.cielOfANumber(ScientificCalculator.java:8)
            at calculator.Calculator.sciCalculator(Calculator.java:77)
            at calculator.Calculator.start(Calculator.java:125)
            at calculator.Calculator.main(Calculator.java:146)
        1
        Select an arithmetic operation : 
        1. Add 
        2. Subtract 
        3. Multiply 
        4. Divide 
        5. Modulo 
        6. Back to Main Menu

Hint : 
- Use appropriate exception handlers as required
- Make use of user-defined exceptions.
- The handler must print the appropriate trace of the   situation.
    
