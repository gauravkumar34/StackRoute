function getAllEmployees() {
  console.log("Fetch all employees");
  //returns a pending promise
  fetch("http://localhost:3000/employees")
    .then((response) => {
      if (response.status === 200) {
        return response.json();
      }
    })
    .then((employees) => {
      //fill the table with the data
      let tbody = document
        .getElementById("employeeList")
        .getElementsByTagName("tbody")[0];
      let tbodyhtml = "";
      employees.forEach((employee) => {
        tbodyhtml += `<tr><td>${employee.id}</td>
                        <td>${employee.empName}</td>
                        <td>${employee.email}</td>
                        <td><button id="delete" onclick="deleteEmployee(${employee.id})">Delete</button></td>
                        <td><button id="edit" onclick="getEmployeeById(${employee.id})">Edit</button></td>`;
      });
      tbody.innerHTML = tbodyhtml;
    })
    .catch((error) => {
      console.log(error);
    });
}

getAllEmployees();

function addEmployee() {
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let newEmp = {
    empName: name,
    email: email,
  };
  //post

  fetch("http://localhost:3000/employees", {
    method: "POST",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(newEmp),
  })
    .then((response) => {
      //201 for post
      if (response.status === 201) {
        console.log("data added");
        getAllEmployees();
      }
    })
    .catch((error) => {
      console.log(error);
    });
}
function getEmployeeById(id) {
  fetch(`http://localhost:3000/employees/${id}`)
    .then((response) => {
      if (response.status === 200) {
        return response.json();
      }
    })
    .then((employee) => {
      document.getElementById("empId").value = employee.id;
      document.getElementById("empName").value = employee.empName;
      document.getElementById("empEmail").value = employee.email;
    })
    .catch((error) => {
      console.log(error);
    });
}

function editEmployee() {
  let empId = document.getElementById("empId").value;
  let empName = document.getElementById("empName").value;
  let email = document.getElementById("empEmail").value;

  fetch(`http://localhost:3000/employees/${empId}`, {
    method: "PUT",
    body: JSON.stringify({
      empName: empName,
      email: email,
    }),
    headers: {
      "Content-type": "application/json",
    },
  })
    .then((response) => {
      if (response === 200) {
        getAllEmployees();
      }
    })
    .then((employee) => {
      document.getElementById("empId").value = employee.id;
      document.getElementById("empName").value = employee.empName;
      document.getElementById("empEmail").value = employee.email;
    })
    .catch((error) => {
      console.log(error);
    });
}
//Delete functionality to be implemented
