import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class RoutesImpl1 {

    static ArrayList readFromFile(String fileName) throws FileNotFoundException {
        ArrayList routes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(", ");

                Routes rr = new Routes();
                rr.setFrom(arr[0]);
                rr.setTo(arr[1]);

                rr.setDistance(Integer.parseInt(arr[2]));
                rr.setTravelTime(arr[3]);
                rr.setAirFare(arr[4]);
                routes.add(rr);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Routes> readAllData = readFromFile("sample-inputs.txt");

        ListIterator<Routes> itr = readAllData.listIterator(); // !task 1
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Enter the City to See Direct Flight  :  ");
        String fromCity = sc.nextLine();

        System.out.println("Direct Flight From " + fromCity + " : \n"); // !task 2
        for (Routes r : readAllData) {
            if (r.getFrom().equals(fromCity)) {
                System.out.println(r);
            }
        }

        System.out.println(" Direct Flight From " + fromCity + " Sorted as of Destination. \n"); // !task 3
        Collections.sort(readAllData, new DirectFlightSort());

        for (Routes r : readAllData) {
            if (r.getFrom().equals(fromCity)) {
                System.out.println(r);
            }
        }

        System.out.println("Enter the Source City :  ");
        String sourceCity = sc.nextLine();
        System.out.println("Enter the Destinations City :  ");
        String destinationCity = sc.nextLine();

        for (Routes r : readAllData) {
            if (r.getFrom().equals(sourceCity) && r.getTo().equals(destinationCity)) {
                System.out.println(r);
            }
            if (r.getFrom().equals(sourceCity)) {
                System.out.println(r);
            }
            if (r.getTo().equals(destinationCity)) {
                System.out.println(r);
            }
        }

    }
}
