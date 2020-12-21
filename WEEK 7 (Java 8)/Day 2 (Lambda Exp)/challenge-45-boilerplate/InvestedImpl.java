import java.util.Scanner;

class SharePriceOpr {
    double amountAfterExchange(double amountInvested, double todayRateUSDtoINR) {
        double amountExchanged = amountInvested * todayRateUSDtoINR;
        return amountExchanged;
    }

    double newStockPrice(double sharePrice, double todayRateUSDtoINR) {
        double USDin1998 = 40;
        double stockPriceIn1998 = sharePrice / USDin1998;
        double todayNewStockPrice = stockPriceIn1998 * todayRateUSDtoINR;
        return todayNewStockPrice;
    }

    double taxPaid(double amountInvested, double todayRateUSDtoINR) {
        double taxPaidToGov = amountAfterExchange(amountInvested, todayRateUSDtoINR) / 10;
        return taxPaidToGov;
    }

    double totalProfitInINR(double amountInvested, double todayRateUSDtoINR) {
        double totalProfit = amountAfterExchange(amountInvested, todayRateUSDtoINR)
                - taxPaid(amountInvested, todayRateUSDtoINR);
        return totalProfit;
    }

    double totalProfitInUSD(double amountInvested, double todayRateUSDtoINR) {
        double totalProfit = totalProfitInINR(amountInvested, todayRateUSDtoINR) / todayRateUSDtoINR;
        return totalProfit;
    }
}

/**
 * investedImpl
 */
public class InvestedImpl {

    static double investedOpr(InvestedRef ir, double investedAmount, double todayRateUSDtoINR) {
        return ir.func(investedAmount, todayRateUSDtoINR);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount invested by the company :");
        double amountInvested = sc.nextInt();
        System.out.println("Enter the share price of the company : ");
        double sharePrice = sc.nextInt();
        System.out.println("Enter the Price rate in USD ");
        double todayRateUSDtoINR = sc.nextDouble();

        System.out.println("Investment amount after increase in exchange rate : 74300.00");
        double sout;
        SharePriceOpr spo = new SharePriceOpr();

        sout = investedOpr((x, y) -> SharePriceOpr.amountAfterExchange(amountInvested, todayRateUSDtoINR),
                amountInvested, todayRateUSDtoINR);
        sout = investedOpr(SharePriceOpr::amountAfterExchange, amountInvested, todayRateUSDtoINR);

        // sout = investedOpr(x -> spo.amountAfterExchange(amountInvested,
        // todayRateUSDtoINR), amountInvested,
        // todayRateUSDtoINR);
        // sout = investedOpr(spo::amountAfterExchange, amountInvested,
        // todayRateUSDtoINR);
    }
}
