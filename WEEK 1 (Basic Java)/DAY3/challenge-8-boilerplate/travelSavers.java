import java.util.Scanner;

public class travelSavers {
    /**
     * this function calculate the present year value of company
     * 
     * @param amountInvested    amount that are invested in 1998
     * @param todayRateUSDtoINR rate of dollor in present year
     * @return value of company in present year
     */
    public static double amountAfterExchange(double amountInvested, double todayRateUSDtoINR) {
        double amountExchanged = amountInvested * todayRateUSDtoINR;
        return amountExchanged;
    }

    /**
     * This function calcuate the price of stock in present year.
     * 
     * @param sharePrice
     * @param todayRateUSDtoINR
     * @return
     */
    public static double newStockPrice(double sharePrice, double todayRateUSDtoINR) {
        double USDin1998 = 40;
        double stockPriceIn1998 = sharePrice / USDin1998;
        double todayNewStockPrice = stockPriceIn1998 * todayRateUSDtoINR;
        return todayNewStockPrice;
    }

    /**
     * This function calculate the amount that to be paid to Indian Government
     * 
     * @param amountInvested
     * @param todayRateUSDtoINR
     * @return
     */
    public static double taxPaid(double amountInvested, double todayRateUSDtoINR) {
        double taxPaidToGov = amountAfterExchange(amountInvested, todayRateUSDtoINR) / 10;
        return taxPaidToGov;
    }

    /**
     * This function calculate the amount the profit in INR
     * 
     * @param amountInvested
     * @param todayRateUSDtoINR
     * @return
     */
    public static double totalProfitInINR(double amountInvested, double todayRateUSDtoINR) {
        double totalProfit = amountAfterExchange(amountInvested, todayRateUSDtoINR)
                - taxPaid(amountInvested, todayRateUSDtoINR);
        return totalProfit;
    }

    /**
     * This function calculate the amount the profit in USD
     * 
     * @param amountInvested
     * @param todayRateUSDtoINR
     * @return
     */

    public static double totalProfitInUSD(double amountInvested, double todayRateUSDtoINR) {
        double totalProfit = totalProfitInINR(amountInvested, todayRateUSDtoINR) / todayRateUSDtoINR;
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount invested by the company :");
        double amountInvested = sc.nextInt();
        System.out.println("Enter the share price of the company : ");
        double sharePrice = sc.nextInt();
        System.out.println("Enter the Price rate in USD ");
        double todayRateUSDtoINR = sc.nextDouble();

        System.out.println("Investment amount after increase in exchange rate :"
                + amountAfterExchange(amountInvested, todayRateUSDtoINR));
        System.out.println("The new price of the stock :" + newStockPrice(sharePrice, todayRateUSDtoINR));
        System.out.println(
                "The tax to be paid on the total shares at 10% :" + taxPaid(amountInvested, todayRateUSDtoINR));
        System.out.println("The total profit in INR :" + totalProfitInINR(amountInvested, todayRateUSDtoINR));
        System.out.println(
                "The total profit converted to dollars :" + totalProfitInUSD(amountInvested, todayRateUSDtoINR));
    }
}
