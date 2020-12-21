
//! Challenge 5 - Temperature Converter
import java.util.Scanner;

public class temperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        float temp;
        String cont;
        do {
            System.out.println("Enter the temperature");
            temp = sc.nextInt();
            System.out.println("Enter the source scale(celcius(c)/fahrenheit(f))?");
            s = sc.next();
            if (s.equalsIgnoreCase("c")) {
                System.out.format("Temperature(Celsius)= " + "%.2f", temp);
                System.out.println();
                System.out.format("Temperature(Fahrenheit)= " + "%.2f", celsiusToFahrenheit(temp));
            } else if (s.equalsIgnoreCase("f")) {
                System.out.format("Temperature(Fahrenheit)= " + "%.2f", temp);
                System.out.println();
                System.out.format("Temperature(Celsius)= " + "%.2f", fahrenheitToCelsius(temp));

            }
            System.out.println();
            System.out.println("Do you wish to continue(y/n)?");
            cont = sc.next();
        } while (cont.equalsIgnoreCase("Y"));
    }

    public static double fahrenheitToCelsius(float n) {
        double c;
        c = (n - 32) * (0.5556);
        return c;
    }

    public static float celsiusToFahrenheit(float n) {
        float f;
        f = ((n * 9) / 5) + 32;
        return f;
    }
}
