/**
 * Create the following functions
1. Create a function called calculateSalary() which takes employee salary as a parameter and increment the salary by 15% and returns the updated salary

Input:  calculateSalary(20000)
Output : 23000

Input : calculateSalary(-2000)
Output: Error : Enter valid input

 */


//module.exports = <mention the function name>;
function calculateSalary(value) {
   
    if(value<0){
        throw new Error('Salary must be positive number');
    }
    else if(value===null)
    {
        throw new Error('Enter Valid Input');
    }
    else if(isNaN(value))
    {
        throw new Error('Enter Valid Input');
    }
    else{
        return value+(value*15/100);
    }
}
    


// calculateSalary(salary);

module.exports = calculateSalary;