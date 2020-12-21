import java.util.Scanner;

public class factorial {

    private static int factorialNum(int n) {
        if (n >= 1)
            return n * factorialNum(n - 1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int factorialOfNumber = factorialNum(n);
        System.out.println(factorialOfNumber);
    }
}
