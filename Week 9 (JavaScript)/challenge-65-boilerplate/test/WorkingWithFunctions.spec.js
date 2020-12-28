const chai = require('chai');
const expect = chai.expect;
const calculateSalary = require('../solution/WorkingWithFunctions.js');

describe('Testing - Working With Functions',()=>{

   it('calculateSalary should be a type of function',()=>{
       //console.log(typeof calculateSalary);       
       expect(typeof calculateSalary).to.equal('function', 
        'Please create calcualteSalary function');
   });

   it('calculateSalary should throw an error for bad input',()=>{
       expect(()=>calculateSalary(-2000)).to.throw('Salary must be positive number');
       expect(()=>calculateSalary('abcd')).to.throw('Enter Valid Input');
       expect(()=>calculateSalary('null')).to.throw('Enter Valid Input');
   });

   it('calculateSalary should return the proper value',()=>{
       expect(calculateSalary(20000)).to.deep.equals(23000);
       expect(calculateSalary(30000)).to.deep.equals(34500);
       
   })





   
   
})