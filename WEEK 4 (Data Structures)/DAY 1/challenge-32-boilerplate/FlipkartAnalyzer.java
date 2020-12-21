import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlipkartAnalyzer {

    static int fileLineCount(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    static FlipkartProductDetails[] readFromFile(String fileName) {
        int noOfRecords = fileLineCount(fileName);
        FlipkartProductDetails[] fs = new FlipkartProductDetails[noOfRecords - 1];
        try (BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {
            br1.readLine();

            int index = 0;
            String line = null;
            while ((line = br1.readLine()) != null) {
                String[] arr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                FlipkartProductDetails f = new FlipkartProductDetails();
                f.setPid(arr[0]);
                f.setProductName(arr[1]);
                f.setBrand(arr[2]);
                f.setProductURL(arr[3]);
                f.setRetailPrice(Double.parseDouble(arr[4]));
                f.setDiscountPrice(Double.parseDouble(arr[5]));
                f.setProductRating(arr[6]);
                fs[index] = f;
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fs;
    }

    /**
     * * this method are used to sorted the data by its Retail Price
     */

    public static FlipkartProductDetails[] sortedByPrice(String fileName) {
        FlipkartProductDetails f[] = readFromFile("data/flipkart_product_sample.csv");
        int z = f.length;
        String tempProdId;
        String tempProdName;
        String tempBrand;
        double tempRetailPrice;
        double tempDiscountPrice;
        for (int i = 0; i < z; i++) {
            for (int j = 1; j < z - i; j++) {
                if (f[j - 1].getRetailPrice() > f[j].getRetailPrice()) {
                    tempProdId = f[j - 1].getPid();
                    f[j - 1].setPid(f[j].getPid());
                    f[j].setPid(tempProdId);

                    tempProdName = f[j - 1].getProductName();
                    f[j - 1].setProductName(f[j].getProductName());
                    f[j].setProductName(tempProdName);

                    tempBrand = f[j - 1].getBrand();
                    f[j - 1].setBrand(f[j].getBrand());
                    f[j].setBrand(tempBrand);

                    tempRetailPrice = f[j - 1].getRetailPrice();
                    f[j - 1].setRetailPrice(f[j].getRetailPrice());
                    f[j].setRetailPrice(tempRetailPrice);

                    tempDiscountPrice = f[j - 1].getDiscountPrice();
                    f[j - 1].setDiscountPrice(f[j].getDiscountPrice());
                    f[j].setDiscountPrice(tempDiscountPrice);

                }
            }

        }
        return f;
    }

    public static FlipkartProductDetails[] sortedByRatingDetails(String fileName) {
        FlipkartProductDetails f[] = readFromFile("data/flipkart_product_sample.csv");
        int z = f.length;
        String tempProdId;
        String tempProdName;
        String tempBrand;
        double tempRetailPrice;
        double tempDiscountPrice;
        for (int i = 0; i < z; i++) {
            for (int j = 1; j < z - 1; j++) {
                if (Double.parseDouble(f[j].getProductRating()) <= 5) {
                    if (Double.parseDouble(f[j].getProductRating()) > Double.parseDouble(f[j - 1].getProductRating())) {
                        tempProdId = f[j - 1].getPid();
                        f[j - 1].setPid(f[j].getPid());
                        f[j].setPid(tempProdId);

                        tempProdName = f[j - 1].getProductName();
                        f[j - 1].setProductName(f[j].getProductName());
                        f[j].setProductName(tempProdName);

                        tempBrand = f[j - 1].getBrand();
                        f[j - 1].setBrand(f[j].getBrand());
                        f[j].setBrand(tempBrand);

                        tempRetailPrice = f[j - 1].getRetailPrice();
                        f[j - 1].setRetailPrice(f[j].getRetailPrice());
                        f[j].setRetailPrice(tempRetailPrice);

                        tempDiscountPrice = f[j - 1].getDiscountPrice();
                        f[j - 1].setDiscountPrice(f[j].getDiscountPrice());
                        f[j].setDiscountPrice(tempDiscountPrice);

                    }
                }
            }

        }
        return f;
    }

    /**
     * * this method are used to write sorted the data by its Retail Price into *
     * !fileName :"data/sortedDataByPrice.csv"
     */

    static void writeToFile() {
        try {
            FlipkartProductDetails fspa[] = sortedByPrice("data/flipkart_product_sample.csv");

            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter("data/sortedDataByPrice.csv"));
            for (int i = 0; i < fspa.length; i++) {
                // Maybe:
                outputWriter.write(fspa[i].getPid() + " " + fspa[i].getProductName() + " " + fspa[i].getBrand() + " "
                        + fspa[i].getProductURL() + " " + fspa[i].getRetailPrice() + " " + fspa[i].getDiscountPrice()
                        + " " + fspa[i].getProductRating());
                // Or:
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void writeToFile2() {
        try {
            FlipkartProductDetails fspa[] = sortedByRatingDetails("data/flipkart_product_sample.csv");

            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter("data/sortedDataByRating.csv"));
            for (int i = 0; i < fspa.length; i++) {
                // Maybe:
                outputWriter.write(fspa[i].getPid() + " " + fspa[i].getProductName() + " " + fspa[i].getBrand() + " "
                        + fspa[i].getProductURL() + " " + fspa[i].getRetailPrice() + " " + fspa[i].getDiscountPrice()
                        + " " + fspa[i].getProductRating());
                // Or:
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // FlipkartProductDetails f[] =
        // readFromFile("data/flipkart_product_sample.csv");
        sortedByPrice("data/flipkart_product_sample.csv");
        System.out.println("No of Records : " + fileLineCount("data/flipkart_product_sample.csv"));
        writeToFile();
        writeToFile2();
    }
}
