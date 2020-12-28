/*
    Write a program for the below instructions
    
    1. Create the variables using let / const  with the below given values
        - companyName    --> StackRoute Ltd
        - companyRevenue --> 34534534.345
        - nullVar        --> null
        - A JSON object (company) with the following Key / Value pair
             id          --> 1
             name        --> stackroute
             email       --> learner.support@stackroute.in
             contactno   --> 111111
             city        --> Bangalore
*/
const companyName = "StackRoute Ltd";
const companyRevenue = 34534534.345;
const nullVar = null;
const values = {"id":1,"name":"stackroute","email":"learner.support@stackroute.in","contactno":111111,"city":"Bangalore"};
// console.log(company);

module.exports = [companyName,companyRevenue,nullVar,values];