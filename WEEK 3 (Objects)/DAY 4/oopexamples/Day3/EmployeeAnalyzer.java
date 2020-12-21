

public class EmployeeAnalyzer {

    public Employee[] acceptEmployeeDetails()
    {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of Employees : ");
        // int n = sc.nextInt();

        Address addr1 = new Address(124, "Main", "Mumbai", 400302);
        Address addr2 = new Address(121, "Drive street", "Bangalore", 560070);
        Address addr3 = new Address(123, "Marble drive", "Hyderabad", 300900);
        Address addr4 = new Address(124, "IT Colony", "Chennai", 600050);
        Address addr5 = new Address(127, "Carson St", "Delhi", 400302);

        Employee emp1 = new Employee(101, "Raj", 10000, addr1);
        Employee emp2 = new Employee(101, "Sam", 60000, addr2);
        Employee emp3 = new Employee(101, "Tim", 30000, addr3);
        Employee emp4 = new Employee(101, "Dave", 10000, addr4);
        Employee emp5 = new Employee(101, "Ava", 40000, addr5);
        
        Employee empList [] = {emp1,emp2,emp3,emp4,emp5};
        //n = 10

        // for(int i =0;i<n;i++)
        // {
        //     Employee emp = new Employee();
        //     System.out.println("Enter the empId : ");
        //     int id = sc.nextInt();
        //     emp.setEmpId(id);
        //     System.out.println("Enter Employee Name : ");
        //     String name = sc.next();
        //     emp.setEmpName(name);
        //     System.out.println("Enter Employee monthly salary : ");
        //     float salary = sc.nextFloat();
        //     emp.setMonthlySalary(salary);
           
        //     Address addr = new Address();
        //     System.out.println("Enter House No : ");
        //     addr.setHouseNo(sc.nextInt());
        //     System.out.println("Enter Street Name : ");
        //     addr.setStreetName(sc.next());
        //     System.out.println("Enter City : ");
        //     addr.setCity(sc.next());
        //     System.out.println("Enter Pincode : ");
        //     addr.setPincode(sc.nextInt());

        //     emp.setAddress(addr);

        //     empList[i] = emp;

            
        // }

        return empList;
    }

    public void displayEmployeeDetails(Employee[] empList)
    {
        System.out.format("%s %15s %15s %15s %15s %25s","Emp Id","Emp Name","Salary","Annual Salary","Address","EmployeeGroup \n");
        for(Employee e:empList)
        {
            System.out.format("%d %15s %15.2f %15.2f %15s %15s",e.getEmpId(),e.getEmpName(),e.getMonthlySalary(),e.getAnnualSalary(),
            e.getAddress().getHouseNo()+e.getAddress().getStreetName()+e.getAddress().getCity()+e.getAddress().getPincode(),e.getEmployeeGroup());
            System.out.println();
        }

    }

    public float calculateHighestSalary(Employee[] empList)
    {
        float highSal = 0;
        highSal = empList[0].getAnnualSalary();
        for(int i=1;i<empList.length;i++)
        {
           
            if(empList[i].getAnnualSalary()>highSal)
            {
                highSal = empList[i].getAnnualSalary();
               
            }

        }

       
        return highSal;
    }


}
