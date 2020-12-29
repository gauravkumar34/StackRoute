const chai = require('chai');
const expect = chai.expect;
const findEmployee = require('../solution/WorkingWithFunctionsExpressions.js');

describe('Testing - Working With Functions Expressions',()=>{
    const empArrayNegativeInput = [
        {id: 1, name: 'emp1', salary: 50000},
        {id: 2, name: 'emp2', salary: 55000},
        {a:1,b:'abcd'},
        {id: 4, name: 'emp4', salary: 30000}
    ];

    const empArrayPositiveInput = [
        {id: 1, name: 'emp1', salary: 50000},
        {id: 2, name: 'emp2', salary: 55000},
        {id: 2, name: 'emp2', salary: 60000},
        {id: 4, name: 'emp4', salary: 30000}
    ]

   it('findEmployee should be a type of function',()=>{
       //console.log(typeof calculateSalary);       
       expect(typeof findEmployee).to.equal('function', 
        'Please create findEmployee function');
   });

   it('findEmployee should throw an error for bad input',()=>{
       expect(()=>findEmployee(-2000)).to.throw('Input must be an Array of employees');
       expect(()=>findEmployee('abcd')).to.throw('Input must be an Array of employees');
       expect(()=>findEmployee('null')).to.throw('Input must be an Array of employees');
   });

   it('Input array must have only employee objects with salary as key',()=>{
       expect(()=>findEmployee(empArrayNegativeInput)).to.throw('Array must contain employee objects with salary key');
   });

   it('findEmployee must return the proper output',()=>{
      expect(findEmployee(empArrayPositiveInput)).to.deep.equals({id: 2, name: 'emp2', salary: 60000});
   })





   
   
})