public class Sales {
    String productName;
    int productSoldInQuarter;
    int totalAmt;

    public Sales(String productName, int productSoldInQuarter, int totalAmt) {
        this.productName = productName;
        this.productSoldInQuarter = productSoldInQuarter;
        this.totalAmt = totalAmt;
    }

    public void costOfOneProduct() {
        System.out.println("Cost of single product " + (totalAmt / productSoldInQuarter));
    }

}
