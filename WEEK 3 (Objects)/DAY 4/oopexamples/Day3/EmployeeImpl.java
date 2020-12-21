public class EmployeeImpl {
    public static void main(String[] args) {
        EmployeeAnalyzer employeeAnalyzer = new EmployeeAnalyzer();
        Employee [] empList = employeeAnalyzer.acceptEmployeeDetails();
        employeeAnalyzer.displayEmployeeDetails(empList);

        System.out.println("The Highest Salary : "+ employeeAnalyzer.calculateHighestSalary(empList));

    }
}
