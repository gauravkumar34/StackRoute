import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InvoiveImpl {

    // filterOut -> product amount > 1000 predicate

    // change category Shoes -> branded shoe Supplier

    public static void main(String[] args) {
        List<Invoice> invoiceList = Arrays.asList(new Invoice("Adidas", 6000, "Shoes"),
                new Invoice("Puma", 10000, "Trouser"), new Invoice("Nike", 6000, "Shoes"),
                new Invoice("RoadStar", 4000, "T-Shirt"));

        Supplier<String> supplierCategoryChanged = () -> "Branded Shoes";

        for (Invoice i : invoiceList) {
            if (i.getProductCategory().equals("Shoes")) {
                i.setProductCategory(supplierCategoryChanged.get());
            }
        }
        invoiceList.forEach(System.out::println);

        Predicate<Invoice> categoryPre = p -> p.getProductCategory().equals("T-Shirt");
        filter(invoiceList, categoryPre);
    }

    static void filter(List<Invoice> list, Predicate<Invoice> pre) {
        System.out.println("deghkfj");
        for (Invoice i : list) {
            if (pre.test(i))
                System.out.println(i);
        }
    }
}
