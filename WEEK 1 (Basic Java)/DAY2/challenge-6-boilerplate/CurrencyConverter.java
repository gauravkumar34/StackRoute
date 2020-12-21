import java.net.PortUnreachableException;
import java.rmi.server.SocketSecurityException;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char s = ' ';
        do {

            float amount;
            String currency;
            System.out.println("Enter the source currency: ");
            currency = sc.next();
            System.out.println("Enter the amount : ");
            amount = sc.nextInt();
            currencyConverter(currency, amount);
            System.out.println("Do you want to continue y or n");
            s = sc.next().charAt(0);
        } while (s == 'y');

    }

    public static void currencyConverter(String currency, float amount) {
        switch (currency) {
            case "USD":
                System.out.println(amount * 74.40);
                break;
            case "GBP":
                System.out.println(amount * 96.64);
                break;
            case "JPY":
                System.out.println(amount * 0.71);
                break;
            case "EUR":
                System.out.println(amount * 86.99);
                break;
            case "AED":
                System.out.println(amount * 20.25);
                break;
            default:
                System.out.println("Invalid Currency");
        }
    }
}
