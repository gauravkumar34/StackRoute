import java.util.Scanner;

public class IPLTeamsRate {
    public static void Rating(int teamName) {
        switch (teamName) {
            case 1:
                System.out.println("Rating is 6.5 ");
                break;
            case 2:
                System.out.println("Rating is 7.5 ");
                break;
            case 3:
                System.out.println("Rating is 8.5 ");
                break;
            case 4:
                System.out.println("Rating is 9.5 ");
                break;
            default:
                System.out.println("Invalid Team Choice ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("IPL Teams");
        System.out.println(" 1. Kings XI \n 2. CSK \n 3. KKR \n 4. MI");
        System.out.println("Select a team : ");
        int teamName = sc.nextInt();
        Rating(teamName);

    }
}
