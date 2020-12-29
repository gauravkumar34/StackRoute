/*
1.	Create the following function using functional programming
       Create a function which takes employee array and return the 
       employee who is having more salary      

*/
function findEmployee(employee) {
  var sortedMax;
  if (Array.isArray(employee)) {
    employee.forEach((s) => {
      if (s.salary == null) {
        throw new Error("Array must contain employee objects with salary key");
      } else {
        //  employee.reduce((sorted, el) => {
        //    var sorted = employee.sort((a, b) => (a.salary > b.salary ? -1 : 1));
        //    return sorted;
        //  });
        var sorted = employee.sort((a, b) => (a.salary > b.salary ? -1 : 1));
        //  console.log(sorted);
        sortedMax = sorted[0];
        //  console.log(sortedMax);
        //  return sorted;
      }
    });
  } else {
    throw new Error("Input must be an Array of employees");
  }
  return sortedMax;
}

module.exports = findEmployee;
