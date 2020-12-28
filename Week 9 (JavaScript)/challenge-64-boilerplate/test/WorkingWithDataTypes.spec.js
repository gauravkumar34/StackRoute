const chai = require('chai');
const expect = chai.expect;
const values = require('../solution/WorkingWithDataTypes.js');

describe('Testing - Workring With DataTypes',()=>{
    // let companyName = 'StackRoute Ltd';
    // let companyRevenue = 34534534.345;
    // let nullVar = null;
    // let company = { id: 1, 
    //                 name : 'stackroute', 
    //                 email : 'learner.support@stackroute.in',
    //                 contactno:111111,
    //                 city : 'Bangalore'    
    //               };

    it('company variable should be a string type',()=>{
        expect(values[0]).to.be.a('string', 'Please declare a variable companyName with value StackRoute Ltd (should be a string type can be declared in a single quote or double quote)');
     })

    it('company variable should have value StackRoute Ltd',()=>{
        expect(values[0]).to.deep.equals('StackRoute Ltd', 
         'Please declare a variable companyName with value StackRoute Ltd (should be a string type can be declared in a single quote or double quote)');
    })

    it('companyRevenue variable should be a number',()=>{
        expect(values[1]).to.be.a('number','Please declare a variable companyRevenue with value 34534534.345 (should be a number type , shouldnot have single quote');
    })

    it('companyRevenue variable should have value 34534534.345' ,()=>{
        expect(values[1]).to.equals(34534534.345,
          'Please declare a variable companyRevenue with value 34534534.345 (should be a number type , shouldnot have single quote');
    })
    it('nullVar variable should be null type',()=>{
        expect(values[2]).to.be.a('null','Please declare a variable nullVar with value null');
    })

    it('nullVar variable should have value null',()=>{
        expect(values[2]).to.equals(null,
        'Please declare a variable nullVar with value null');
    })

    it('company variable should be object type',()=>{
        expect(values[3]).to.be.a('object',
               'Please declare a variable company with the proper key/value and should be a null');
    })

    it('company variable should have the proper values',()=>{
        expect(values[3]).to.include({id:1,name : 'stackroute', 
        email : 'learner.support@stackroute.in',
        contactno:111111,
        city : 'Bangalore' });
    })
   
   
})