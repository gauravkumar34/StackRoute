import java.util.Scanner;

public class demo {
    /**
     * This Function only printing the table of the route information display.
     * 
     * @param routes (task 1)
     */
    private static void displayTable(String[] routeInfo) {
        System.out.printf("%s\t%15s\t%15s\t%15s\t%10s", "Source", "Destination", "Distance", "Time", "Price");
        System.out.println("\n");
        String[] routeElement = null;

        for (int i = 0; i < routeInfo.length; i++) {
            routeElement = routeInfo[i].split(", ");
            System.out.format("%s\t%15s\t%15s\t%15s\t%10s\n", routeElement[0], routeElement[1], routeElement[2],
                    routeElement[3], routeElement[4]);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] routeInfo = new String[n];
        for (int i = 0; i < n; i++) {
            routeInfo[i] = sc.nextLine();
        }

        displayTable(routeInfo);

    }
}
