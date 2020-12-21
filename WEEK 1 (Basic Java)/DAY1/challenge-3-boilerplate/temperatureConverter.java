import java.util.Scanner;

public class temperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String c;
        float n;
        do {
            System.out.println("Enter the temperature in Degree Celsius:");
            n = sc.nextInt();
            float f;
            f = ((n * 9) / 5) + 32;
            System.out.format("Temperature(Celsius)= " + "%.2f ", n);
            System.out.println("\n");
            System.out.format("Temperature(Fahrenheit)= " + "%.2f ", f);
            System.out.println("\n");
            System.out.println("Do you wish to continue(y/n)?");
            c = sc.next();
        } while (c.equalsIgnoreCase("Y"));
    }
}
