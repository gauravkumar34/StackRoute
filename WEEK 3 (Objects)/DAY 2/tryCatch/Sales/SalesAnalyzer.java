public class SalesAnalyzer {
    public static void main(String[] args) {
        Sales sales = new Sales("MI", 3, 60000);
        try {
            sales.costOfOneProduct();

        } catch (ArithmeticException e) {
            System.out.println("\nDivide by zero error, enter a valid no products");
        }

    }
}
