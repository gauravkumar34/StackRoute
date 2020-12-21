public class SalesAnalyzer {
    public static void main(String[] args) {
        Sales sales = new Sales("MI 10",0,60000);
        try{
        sales.costOfOneProduct();
        }
        catch(ArithmeticException e){
            System.out.println("Divide by zero error, enter a valid no of products");
            //get the calues from user
        }
    }
}
