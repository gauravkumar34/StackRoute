public class PrimeInterfaceImpl {
    public static void main(String[] args) {
        PrimeInterface p = (no) -> {
            boolean flag = false;
            for (int i = 2; i <= no / 2; i++) {
                if (no % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return no + " is a prime number";
            else
                return no + " is not prime";
        };
        System.out.println(p.findPrime(32));
    }
}
