import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Supplier;

public class PurchaseImpl {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    static ArrayList readFromFile(String fileName) {
        ArrayList purchaseDet = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");

                Purchase pr = new Purchase();
                pr.setDate(arr[0]);
                // // try {
                // // System.out.println(pr.getDate());
                // // } catch (ParseException e) {
                // // e.printStackTrace();
                // }
                pr.setCustomerId(Integer.parseInt(arr[1]));
                pr.setProductCategory(Integer.parseInt(arr[2]));
                pr.setPaymentMethod(arr[3]);
                pr.setValue(Double.parseDouble(arr[4]));
                pr.setTimeOnSite(Double.parseDouble(arr[5]));
                pr.setNoOfClicks(Integer.parseInt(arr[6]));

                purchaseDet.add(pr);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return purchaseDet;
    }

    public static void dateFollowedBYPayment(ArrayList<Purchase> readALLData) {
        for (Purchase p : readALLData) {
            p.getDate();
            p.getPaymentMethod();
            System.out.println(p.getDate() + " " + p.getPaymentMethod());

        }
    }

    public static void creditCardAnalysis(ArrayList<Purchase> readALLData) {
        for (Purchase p : readALLData) {
            if (p.getPaymentMethod().equals("credit")) {
                System.out.println(p.getCustomerId() + " " + p.getDate());
            }
        }
    }

    public static void highestPurchases(ArrayList<Purchase> readALLData) {
        // double maxValue = 0;
        for (Purchase p : readALLData) {

            p.getValue();

        }
    }

    public static void replaceNoofClick(ArrayList<Purchase> readALLData) {
        Supplier<Integer> supplierNoOfClick = () -> 1;
        for (Purchase p : readALLData) {
            if (p.getNoOfClicks() == 0) {
                p.setNoOfClicks(supplierNoOfClick.get());
            }
        }
        readALLData.forEach(System.out::println);

    }

    public static void listPurchaseOnDate(ArrayList<Purchase> readALLData) {
        for (Purchase p : readALLData) {
            if (p.getDate().equals("23/11/18")) {
                System.out.println(p.getDate() + " " + p.getCustomerId() + " " + p.getProductCategory() + " "
                        + p.getValue() + " " + p.getPaymentMethod());
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Purchase> readALLData = readFromFile("data_purchase_details.csv");
        dateFollowedBYPayment(readALLData);
        creditCardAnalysis(readALLData);
        highestPurchases(readALLData);
        // replaceNoofClick(readALLData); //!not find logic
        listPurchaseOnDate(readALLData);

    }
}
