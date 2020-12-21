import java.util.Scanner;

public class EmployeeAnalyzer {

    public Employee[] acceptEmployeeDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Employees : ");
        int n = sc.nextInt();

        Employee empList[] = new Employee[n];
        // n = 10

        for (int i = 0; i < n; i++) {
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

            Address addr = new Address();
            System.out.println("Enter House No :");
            addr.setHouseNo(sc.nextInt());
            System.out.println("Enter Street Name No :");
            addr.setStreetName(sc.next());
            System.out.println("Enter City  :");
            addr.setCity(sc.next());
            System.out.println("Enter Pincode  :");
            addr.setPincode(sc.nextInt());

            emp.setAddress(addr);
            empList[i] = emp;

        }

        return empList;
    }

    public void displayEmployeeDetails(Employee[] empList) {
        System.out.format("%s %15s %15s %15s %15s", "Emp Id", "Emp Name", "Salary", "Annual Salary", "Address\n");
        for (Employee e : empList) {
            System.out.format("%d %15s %15.2f %15.2f\t %15s", e.getEmpId(), e.getEmpName(), e.getMonthlySalary(),
                    e.getAnnualSalary(), e.getAddress().getHouseNo() + "  " + e.getAddress().getStreetName() + "  "
                            + e.getAddress().getCity() + "  " + e.getAddress().getPincode());
            System.out.println();
        }

    }

    public float calculateHighestSalary(Employee[] empList) {
        float highSal = 0;
        for (int i = 0; i < empList.length; i++) {
            highSal = empList[0].getAnnualSalary();
            if (empList[i].getAnnualSalary() > highSal) {
                highSal = empList[i].getAnnualSalary();

            }

        }

        return highSal;
    }

}
