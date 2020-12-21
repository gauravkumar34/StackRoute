import java.util.Date;

public class Purchase {

    private String date;
    private int customerId;
    private int productCategory;
    private String paymentMethod;
    private double value;
    private double timeOnSite;
    private int NoOfClicks;

    public Purchase() {
        this.date = date;
        this.customerId = customerId;
        this.productCategory = productCategory;
        this.paymentMethod = paymentMethod;
        this.value = value;
        this.timeOnSite = timeOnSite;
        this.NoOfClicks = NoOfClicks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getTimeOnSite() {
        return timeOnSite;
    }

    public void setTimeOnSite(double timeOnSite) {
        this.timeOnSite = timeOnSite;
    }

    public int getNoOfClicks() {
        return NoOfClicks;
    }

    public void setNoOfClicks(int NoOfClicks) {
        this.NoOfClicks = NoOfClicks;
    }

    @Override
    public String toString() {
        return "Purchase [NoOfClicks=" + NoOfClicks + ", customerId=" + customerId + ", date=" + date
                + ", paymentMethod=" + paymentMethod + ", productCategory=" + productCategory + ", timeOnSite="
                + timeOnSite + ", value=" + value + "]";
    }

}