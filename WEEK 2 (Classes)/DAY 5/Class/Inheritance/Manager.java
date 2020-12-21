package Inheritance;

public class Manager extends Employee {
    int teamSize;
    int teamRatings;

    public Manager(int empId, double salary, String name,int teamSize,int teamRatings) {
        super(empId, salary, name);
      this.teamRatings = teamRatings;
      this.teamSize = teamSize;
    }


    public double calculateIncrement(float hikePercentage)
    {
        if(teamRatings>=7)
            salary = salary*hikePercentage;
        return salary;
    }
}

   
