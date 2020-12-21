public class EmployeeImpl {

    public static void main(String[] args) {
        Employee[] empList = Employee.acceptEmployeeDetails();
        Employee emp = new Employee();
        emp.displayEmployeeDetails(empList);
        System.out.println("Highest Salary owned Employess : ");
        double highestSalary = emp.calculateHighestSalary(empList);
        System.out.println("\n" + highestSalary);
    }
}
