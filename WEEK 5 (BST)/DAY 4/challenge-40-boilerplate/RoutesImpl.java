import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class RoutesImpl {

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
                // rr.setAirFare(arr[4]); // ! error
                routes.add(rr);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }

    static ArrayList showDirectFlight(String fileName, String currCity) throws FileNotFoundException {

        ArrayList routes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(", ");

                Routes rr = new Routes();
                rr.setFrom(arr[0]);
                if (rr.getFrom().equals(currCity)) {
                    rr.setTo(arr[1]);
                    rr.setDistance(Integer.parseInt(arr[2]));
                    rr.setTravelTime(arr[3]);
                    rr.setAirFare(arr[4]);
                    routes.add(rr);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }

    static ArrayList allConnections(String fileName, String currCity, String toGoCity) throws FileNotFoundException {
        ArrayList routes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(", ");

                Routes rr = new Routes();
                rr.setFrom(arr[0]);
                rr.setTo(arr[1]);
                if (rr.getTo().equals(toGoCity) && rr.getFrom().equals(currCity)) {
                    rr.setDistance(Integer.parseInt(arr[2]));
                    rr.setTravelTime(arr[3]);
                    rr.setAirFare(arr[4]);
                    routes.add(rr);

                }
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

        ArrayList<Routes> rr = readFromFile("sample-inputs.txt");

        for (Routes s : rr) {
            System.out.println(s.getTo());
        }
        ListIterator<Routes> itrr = rr.listIterator();
        while (itrr.hasNext()) {
            System.out.println(itrr.next());
        }

        System.out.println("\nEnter the City Name To See Direct Flight : \n");
        String currCity = sc.nextLine();
        ArrayList<Routes> directFlight = showDirectFlight("sample-inputs.txt", currCity);

        ListIterator<Routes> itr = directFlight.listIterator();
        System.out.println("\n\nShow Direct Flight From  : " + currCity + "\n");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        Collections.sort(directFlight, new DirectFlightSort());
        System.out.println("\n\nShow Sorted  Direct Flight From  : " + currCity + "\n");
        ListIterator<Routes> itrSort = directFlight.listIterator();

        while (itrSort.hasNext()) {
            System.out.println(itrSort.next());
        }
        System.out.println("Enter the Name of the city from where want to travel :");

        String fromCity = sc.nextLine();
        System.out.println("Enter the Name of the city want to travel :");
        String toGoCity = sc.nextLine();

        ArrayList<Routes> allconnection = allConnections("sample-inputs.txt", fromCity, toGoCity);
        ListIterator<Routes> itrrr = allconnection.listIterator();
        System.out.println("<><<<<<<<<<<<<<<<>>>>>>>>>");
        while (itrrr.hasNext()) {
            System.out.println(itrrr.next());
        }

    }
}

/**
 * This is long method to slove this challange
 * 
 */