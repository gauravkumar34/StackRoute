import java.util.Scanner;

public class CustomerImpl {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the your choise : ");
        System.out.println("\t1. Create New Account.");
        System.out.println("\t2. Transactions.");
        System.out.println("\t3. Exit.\n");

        int n = sc.nextInt();
        CustomerAnalyzer customerAnalyzer = new CustomerAnalyzer();
        // SavingAccountAnalyze savingAccountAnalyze = new SavingAccountAnalyze();
        switch (n) {
            case 1:
                Customer[] custList = customerAnalyzer.acceptCustomerDetails();
                customerAnalyzer.displayCustomerDetails(custList);
                break;
            case 2:
                // System.out.println("\nTotal Balance : " +
                // savingAccountAnalyze.totalBalance());
                break;
            case 3:
                System.out.println("\nThanks For Using Our Services... ");
                break;

            default:
                System.out.println("Please Enter the Valid Options. Start Again. ");
                break;
        }
    }
}
