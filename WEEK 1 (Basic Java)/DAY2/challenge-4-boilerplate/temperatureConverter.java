import java.util.Scanner;

public class temperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s;
        float c;
        do {
            System.out.println("Enter the temperature in Degree Celsius:");
            c = sc.nextInt();
            System.out.println("Temperature(Celsius)= " + c);
            // System.out.println("\n");
            System.out.println("Temperature(Fahrenheit)= " + celsiusToFahrenheit(c));
            System.out.println("Do you wish to continue(y/n)?");
            s = sc.next();
        } while (s.equalsIgnoreCase("Y"));
    }

    public static float celsiusToFahrenheit(float n) {
        float f;
        f = ((n * 9) / 5) + 32;
        return f;
    }
}
