

public class Employee {
    private int empId;
    private String empName;
    private float monthlySalary;
    private float annualSalary;
    private Address address;
    //seggregate the Employees into groups -> Bands -> A, B, C -> hike -> band wise
    private EmployeeGroup employeeGroup;
    
    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

   
    public float getMonthlySalary() {
        return monthlySalary;
    }
 

    public float getAnnualSalary() {      
        setAnnualSalary(monthlySalary*12);
        return annualSalary;
    }
    
    
    public void setMonthlySalary(float monthlySalary) {
       
        this.monthlySalary = monthlySalary;
    }

     private void setAnnualSalary(float annualSalary) {
         
        this.annualSalary = annualSalary;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(int empId, String empName, float monthlySalary, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.monthlySalary = monthlySalary;
        this.address = address;
        this.annualSalary = getAnnualSalary();
        this.employeeGroup = getEmployeeGroup();
    }

    public EmployeeGroup getEmployeeGroup() {
        setEmployeeGroup();
        return employeeGroup;
    }

    private void setEmployeeGroup() {
        if(monthlySalary>=10000 && monthlySalary<=30000)
            this.employeeGroup = EmployeeGroup.C;
        else if(monthlySalary>30000 && monthlySalary<=50000)
            this.employeeGroup = EmployeeGroup.B;
        else if(monthlySalary>50001)
            this.employeeGroup = EmployeeGroup.A;
    }
    
   
    
    
      
}
