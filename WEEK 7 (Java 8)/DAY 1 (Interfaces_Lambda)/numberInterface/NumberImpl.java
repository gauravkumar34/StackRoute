/**
 * *Functional Programming
 */
public class NumberImpl {
    public static void main(String[] args) {

        Numbers numbers = new Numbers() {

            @Override
            public String oddOrEven(int number) {
                if (number % 2 == 0)
                    return number + " is Even";
                else
                    return number + " is Odd";
            }

        };

        String result = numbers.oddOrEven(34);
        System.out.println(result);

        Multiply m = new Multiply() {

            @Override
            public int multiply(int a, int b) {
                int z = a * b;
                return z;
            }

        };
        int n = m.multiply(3, 7);
        System.out.println(n);
    }
}
