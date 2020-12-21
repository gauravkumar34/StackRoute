import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int n, tc;
        System.out.println("Enter the how many temp you want to convert.");
        n = myObj.nextInt();
        int[] tf = new int[n];
        for (int i = 0; i < n; i++) {
            tc = i * 10;
            tf[i] = ((tc * 9) / 5) + 32;

        }
        System.out.println("Sr. No" + " " + "Temperature(Celsius)" + " Temperature(Fahrenheit)");
        for (int i = 0; i < n; i++) {
            System.out.println("     " + (i + 1) + "         " + (i * 10) + "                              " + tf[i]);
            // System.out.println(i + 1 + " " + i * 10 + " " + tf[i]);

        }
    }
}
