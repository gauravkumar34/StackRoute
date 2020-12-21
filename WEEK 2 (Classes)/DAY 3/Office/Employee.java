import java.util.Scanner;

public class Employee {
    int empId;
    String empName;
    double monthlySalary;
    double annualSalary;

    // Construction Overloading
    public Employee() {

    }

    public Employee(int empId, String empName, double monthlySalary, double annualSalary) {
        this.empId = empId;
        this.empName = empName;
        this.monthlySalary = monthlySalary;
        this.annualSalary = annualSalary;
    }

    public static Employee[] acceptEmployeeDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Employees : ");

        int n = sc.nextInt();
        Employee empList[] = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the empId : ");
            int id = sc.nextInt();
            System.out.println("Enter Employee Name : ");
            String name = sc.next();
            System.out.println("Enter the Employee Monthy salary");
            double salary = sc.nextDouble();
            double aSalary = salary * 12;
            Employee emp = new Employee(id, name, salary, aSalary);

            empList[i] = emp;
        }
        return empList;
    }

    public void displayEmployeeDetails(Employee[] empList) {
        System.out.format("%s %15s %15s %15s \n", "Emp Id", "Emp Name", "Emp Salary", "Emp AnnaulSalary");
        for (Employee e : empList) {
            System.out.format("\n %d %15s %15.2f %15.2f \n", e.empId, e.empName, e.monthlySalary, e.annualSalary);

        }

    }

    public double calculateHighestSalary(Employee[] empList) {
        double highSal = 0;
        for (int i = 0; i < empList.length; i++) {
            highSal = empList[0].annualSalary;
            if (empList[i].annualSalary > highSal) {
                highSal = empList[i].annualSalary;
            }

        }
        return highSal;
    }
}
