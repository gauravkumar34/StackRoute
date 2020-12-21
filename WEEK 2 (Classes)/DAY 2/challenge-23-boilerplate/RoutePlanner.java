import java.util.Scanner;

public class RoutePlanner {

    /**
     * This Function only printing the table of the route information display.
     * 
     * @param routes (task 1)
     */
    private static void displayTable(String[] routeInfo, String fromCity) {
        String[] fromCityStoredData = new String[5];

        System.out.printf("%s\t%15s\t%15s\t%15s\t%10s", "Source", "Destination", "Distance", "Time", "Price");
        System.out.println("\n");
        String[] routeElement = null;
        for (int i = 0; i < routeInfo.length; i++) {
            routeElement = routeInfo[i].split(", ");
            System.out.format("%s\t%15s\t%15s\t%15s\t%10s\n", routeElement[0], routeElement[1], routeElement[2],
                    routeElement[3], routeElement[4]);
            System.out.println();
            // int k = 0;
            if (fromCity.equals(routeElement[0])) {
                fromCityStoredData[i] = routeInfo[i];

            }
        }
        showDirectFlights(fromCityStoredData, fromCity);

    }

    private static void showDirectFlights(String[] fromCityStoredData, String fromCity) {
        System.out.println("\n\n                        Flights" + " From " + fromCity + "             \n");
        System.out.printf("%s\t%15s\t%15s\t%15s\t%10s", "Source", "Destination", "Distance", "Time", "Price");
        System.out.println("\n");
        String[] routeElement = null;
        for (int i = 0; i < fromCityStoredData.length; i++) {
            routeElement = fromCityStoredData[i].split(", ");
            System.out.format("%s\t%15s\t%15s\t%15s\t%10s\n", routeElement[0], routeElement[1], routeElement[2],
                    routeElement[3], routeElement[4]);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] routeInfo = { "Delhi, Mumbai, 1148, 2:10, INR6000", "Delhi, London, 6704, 8:55, INR37000",
                "Delhi, Bengaluru, 1740, 2:30, INR9000", "Delhi, Singapore, 4160, 5:30, INR12500",
                "Delhi, Frankfurt, 6117, 8:35, INR32000", "Mumbai, London, 7187, 9:30, INR28000",
                "Mumbai, Bengaluru, 845, 1:32, INR4200", "Mumbai, Frankfurt, 6209, 8:55, INR25000",
                "Bengaluru, Singapore, 3180, 4:25, INR8500", "Frankfurt, London, 660, 1:25, EUR155" };

        System.out.println("Enter the Place to Compare With : ");
        String fromCity = sc.nextLine();

        displayTable(routeInfo, fromCity);

    }
}
