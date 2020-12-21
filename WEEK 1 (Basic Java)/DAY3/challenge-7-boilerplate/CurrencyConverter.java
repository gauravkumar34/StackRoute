import java.util.Scanner;

public class CurrencyConverter {
    /**
     * this function taking array as
     * 
     * @param amountINR print the table of currency convert INR to USD, JPY, GBP
     */
    public static void currencyConverter(double[] amountINR) {
        System.out.println("|Denominations(INR)|\tUSD|\t\tJPY|\t\tGBP|");
        for (int i = 0; i < 5; i++) {
            double USD = 74.3, JPY = 0.67, GBP = 94.5;
            USD *= amountINR[i];
            JPY *= amountINR[i];
            GBP *= amountINR[i];
            System.out.format("\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\n", amountINR[i], USD, JPY, GBP);
        }
    }

    /**
     * this function convert your amount to your desired currency
     * 
     * @param currencyHave
     * @param amountHave
     * @param desiredCurrency
     */

    public static void desiredCurrencies(int currencyHave, double amountHave, int desiredCurrency) {
        switch (currencyHave) {
            case 1:
                usdHave(amountHave, desiredCurrency);
                break;
            case 2:
                jpyHave(amountHave, desiredCurrency);
                break;
            case 3:
                eurHave(amountHave, desiredCurrency);
                break;
            case 4:
                gbpHave(amountHave, desiredCurrency);
                break;
            default:
                System.out.println("Invalid Input");
                break;

        }
    }

    /**
     * this function convert amount in USD to desirecurrency
     * 
     * @param amountHave
     * @param desiredCurrency
     */
    public static void usdHave(double amountHave, int desiredCurrency) {
        switch (desiredCurrency) {
            case 1:
                System.out.println("Amount Converted from USD to USD  " + (amountHave));
            case 2:
                System.out.println("Amount Converted from USD to JPY  " + (amountHave * 104.88));
                break;
            case 3:
                System.out.println("Amount Converted from USD to Euro  " + (amountHave * 0.86));
                break;
            case 4:
                System.out.println("Amount Converted from USD to GBP  " + (amountHave * 0.77));
            default:
                System.out.println("Invalid Input");
        }
    }

    /**
     * this function convert amount in JPY to desirecurrency
     * 
     * @param amountHave
     * @param desiredCurrency
     */
    public static void jpyHave(double amountHave, int desiredCurrency) {
        switch (desiredCurrency) {
            case 1:
                System.out.println("Amount Converted from JPY to USD  " + (amountHave * 0.0095));
                break;
            case 2:
                System.out.println("Amount Converted from JPY to JPY  " + (amountHave));
                break;
            case 3:
                System.out.println("Amount Converted from JPY to Euro  " + (amountHave * 0.0082));
                break;
            case 4:
                System.out.println("Amount Converted from JPY to GBP  " + (amountHave * 0.0073));
            default:
                System.out.println("Invalid Input");
        }
    }

    /**
     * this function convert amount in EUR to desirecurrency
     * 
     * @param amountHave
     * @param desiredCurrency
     */
    public static void eurHave(double amountHave, int desiredCurrency) {
        switch (desiredCurrency) {
            case 1:
                System.out.println("Amount Converted from EUR to USD  " + (amountHave * 1.17));
                break;
            case 2:
                System.out.println("Amount Converted from EUR to JPY  " + (amountHave * 122.26));
                break;
            case 3:
                System.out.println("Amount Converted from EUR to EUR  " + (amountHave));
                break;
            case 4:
                System.out.println("Amount Converted from EUR to GBP  " + (amountHave * 0.90));
            default:
                System.out.println("Invalid Input");
        }
    }

    /**
     * this function convert amount in GBP to desirecurrency
     * 
     * @param amountHave
     * @param desiredCurrency
     */
    public static void gbpHave(double amountHave, int desiredCurrency) {
        switch (desiredCurrency) {
            case 1:
                System.out.println("Amount Converted from GPB to USD  " + (amountHave * 1.30));
                break;
            case 2:
                System.out.println("Amount Converted from GPB to JPY  " + (amountHave * 136.26));
                break;
            case 3:
                System.out.println("Amount Converted from GPB to EUR  " + (amountHave * 1.11));
                break;
            case 4:
                System.out.println("Amount Converted from GPB to GBP  " + (amountHave));
            default:
                System.out.println("Invalid Input");
        }
    }

    public static void main(String[] args) {
        double[] amountINR = new double[] { 1, 10, 20, 50, 100 };
        currencyConverter(amountINR);
        Scanner sc = new Scanner(System.in);
        System.out.println("\n <-------------- CURRENCY CONVERTER ------------ >");
        System.out.println("Enter the Currency that you have : \n 1. USD \n 2. JPY \n 3. EUR \n 4. GBP");
        int currencyHave = sc.nextInt();
        System.out.println("Enter the Amount you want to convert : \n");
        double amountHave = sc.nextInt();
        System.out.println("Enter the Desired Currency You want to Convert : \n 1. USD \n 2. JPY \n 3. EUR \n 4. GBP");
        int desiredCurrency = sc.nextInt();

        desiredCurrencies(currencyHave, amountHave, desiredCurrency);

    }
}
