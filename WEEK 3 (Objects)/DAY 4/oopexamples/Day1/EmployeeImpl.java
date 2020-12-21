public class EmployeeImpl {
    public static void main(String[] args) {
        Employee [] empList = Employee.acceptEmployeeDetails();
        Employee emp = new Employee();
        emp.displayEmployeeDetails(empList);

        System.out.println("The highest salary : "+emp.calculateHighestSalary(empList));
    }
}
