

public class Employee {
    private int empId;
    private String empName;
    private float monthlySalary;
    private float annualSalary;//immutable property // 12 months* salary => 
    //read only access to annualSalary -> 
    
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
    
    
    
    
    
      
}
