package Inheritance;

public abstract class Employee {

    int empId;
    double salary;
    String name;
        
    public void displayEmployeePersonalInformation()
    {
        System.out.println(name +" :: "+salary);
    }

    public Employee(int empId, double salary, String name) {
        this.empId = empId;
        this.salary = salary;
        this.name = name;
    }
    public abstract double calculateIncrement(float hikePercentage);
    

}
