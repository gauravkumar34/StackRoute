import java.util.Scanner;

public class VoterImpl {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name :");
        String name = sc.next();
        System.out.println("Enter VoterId : ");
        String voterId = sc.next();
        System.out.println("Enter voter age : ");
        int age = sc.nextInt();
        
        Voter v = new Voter();
        
        try{
         v.validateAge(age);
        }
        catch(AgeException e)
        {

        }

        System.out.println("Control back main method");

    }
}
