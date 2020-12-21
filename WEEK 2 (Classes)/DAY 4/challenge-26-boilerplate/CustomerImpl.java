
public class CustomerImpl {

    public static void main(String[] args) {
        CustomerAnalyzer customerAnalyzer = new CustomerAnalyzer();
        Customer[] custList = customerAnalyzer.acceptCustomerDetails();
        customerAnalyzer.displayCustomerDetails(custList);
        customerAnalyzer.displaySameVillage(custList);
    }
}
