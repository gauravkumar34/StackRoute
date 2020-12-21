package Inheritance;

public class RegionalHead extends Employee{
    String regionName;
    int regionPerformance;
    int reviewRatings;
    public RegionalHead(int empId, double salary, String name,String regionName,int regionPerformance,int reviewRatings) {
      super(empId, salary, name);      
        this.regionName = regionName;
        this.regionPerformance = regionPerformance;
        this.reviewRatings = reviewRatings;
      
    }
    public void displayEmployeePersonalInformation()
    {
        super.displayEmployeePersonalInformation();//use this to call parent class method
        System.out.println(name +" :: "+salary+" :: "+regionName);
    }

    public double calculateIncrement(float hikePercentage)
    {
        if(regionPerformance>=7 && reviewRatings>=8)
          salary = salary*hikePercentage;
        return salary;
    }

   

    
}
