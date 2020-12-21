package Inheritance;

public class EmployeeMain {
    public static void main(String[] args) {
        
        Employee regionalHead = new RegionalHead(101, 40000, "Tom", "South", 8, 8);
        Employee manager = new Manager(102, 20000, "Gary", 6, 8);
        
//at compile time -> regionalHead is of type Employee
//at runtime -> regionalHead is of type RegionalHead

       
        regionalHead.displayEmployeePersonalInformation();
        System.out.println("Hike - "+regionalHead.calculateIncrement(1.3f));
        
        manager.displayEmployeePersonalInformation();  
        System.out.println("Hike - "+manager.calculateIncrement(1.2f));
    }
   


    
}
