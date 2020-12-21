import java.util.Scanner;

public class primeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = ' ';
        do {
            System.out.println("Enter a number : ");
            int number = sc.nextInt();
            if (number <= 0 || number == 1) {
                System.out.println("Entered Number is Either 0 and 1");
                continue;
            }
            boolean flag = false;
            for (int i = 2; i < number / 2; i++) {
                if (number % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag == true)
                System.out.println(number + " is not prime");
            else
                System.out.println(number + " is prime");
            System.out.println("y/n");
            ch = sc.next().charAt(0);
        } while (ch == 'y');
    }
}
