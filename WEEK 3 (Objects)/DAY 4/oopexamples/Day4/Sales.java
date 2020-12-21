public class Sales{
    String productName;
    int productsSoldInQuarter;
    int totalAmt;

    public Sales(String productName, int productsSoldInQuarter, int totalAmt) {
        this.productName = productName;
        this.productsSoldInQuarter = productsSoldInQuarter;
        this.totalAmt = totalAmt;
    }


    //calculate the cost of a single product

    //mi 10 phones -> 10

    public void costOfOneProduct()
    {
        System.out.println("Cost of single product"+(totalAmt/productsSoldInQuarter));
    }
    
}