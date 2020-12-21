import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StockAnalysis {
    static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

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

    static Stock[] readFromFile(String fileName) {
        int noOfRecords = fileLineCount(fileName);
        Stock[] stocks = new Stock[noOfRecords - 1];

        try (BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {
            br1.readLine();
            int index = 0;
            String line = null;
            while ((line = br1.readLine()) != null) {
                String[] arr = line.split(",");
                Stock s = new Stock();
                // s.setDate(arr[0]);
                s.setHigh(Double.parseDouble(arr[2]));
                s.setAdjClose(Double.parseDouble(arr[5]));
                // try {

                // s.setDate(sdf.parse(arr[0]));
                // } catch (ParseException e) {

                // e.printStackTrace();
                // }

                stocks[index] = s;
                index++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public static void main(String[] args) {
        Stock s[] = readFromFile("data/CIPLA.NS.csv");
        System.out.println(s.length);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i].getDate() + " " + s[i].getHigh() + " " + s[i].getAdjClose());
        }
    }

}
