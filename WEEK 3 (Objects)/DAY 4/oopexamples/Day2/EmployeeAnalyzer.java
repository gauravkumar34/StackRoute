import java.util.Scanner;

public class EmployeeAnalyzer {

    public Employee[] acceptEmployeeDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Employees : ");
        int n = sc.nextInt();

        Employee empList [] = new Employee[n];
        //n = 10

        for(int i =0;i<n;i++)
        {
            Employee emp = new Employee();
            System.out.println("Enter the empId : ");
            int id = sc.nextInt();
            emp.setEmpId(id);
            System.out.println("Enter Employee Name : ");
            String name = sc.next();
            emp.setEmpName(name);
            System.out.println("Enter Employee monthly salary : ");
            float salary = sc.nextFloat();
            emp.setMonthlySalary(salary);
            empList[i] = emp;
            
        }

        return empList;
    }

    public void displayEmployeeDetails(Employee[] empList)
    {
        System.out.format("%s %15s %15s %15s","Emp Id","Emp Name","Salary","Annual Salary\n");
        for(Employee e:empList)
        {
            System.out.format("%d %15s %15.2f %15.2f",e.getEmpId(),e.getEmpName(),e.getMonthlySalary(),e.getAnnualSalary());
            System.out.println();
        }

    }

    public float calculateHighestSalary(Employee[] empList)
    {
        float highSal = 0;
        for(int i=0;i<empList.length;i++)
        {
            highSal = empList[0].getAnnualSalary();
            if(empList[i].getAnnualSalary()>highSal)
            {
                highSal = empList[i].getAnnualSalary();
               
            }

        }

       
        return highSal;
    }


}
