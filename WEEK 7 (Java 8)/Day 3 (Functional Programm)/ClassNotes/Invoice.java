public class Invoice {
    private String name;
    private int amount;
    private String productCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Invoice(String name, int amount, String productCategory) {
        this.name = name;
        this.amount = amount;
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Invoice [amount=" + amount + ", name=" + name + ", productCategory=" + productCategory + "]";
    }

}
