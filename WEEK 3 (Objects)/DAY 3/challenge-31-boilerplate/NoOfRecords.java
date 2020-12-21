import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class NoOfRecords {

    public static void main(String[] args) {
        int totalLines = new NoOfRecords().countLineNumber();
        System.out.println("Total Number Lines " + totalLines);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Previous Date (YYYY-MM-DD) :");
        String prevDate = sc.next();
        System.out.println("Enter the Current Date (YYYY-MM-DD) :");
        String currDate = sc.next();

        // * taking values of absoluteReturn Method
        double absoluteReturn = new NoOfRecords().AbsoluteReturn(prevDate, currDate);
        System.out.format("\n%s", "Absolute Return : ");
        System.out.format("%5.2f %s", absoluteReturn, "%");
    }

    /**
     ** this method count the no of record
     ** 
     * @return return the count of the no of records
     */
    public int countLineNumber() {
        int lines = 0;
        try {
            File file = new File("data/CIPLA.NS.csv");
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
            lineNumberReader.skip(Long.MAX_VALUE);
            lines = lineNumberReader.getLineNumber();
            lineNumberReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return lines;
    }

    /*
     * /** this function return the absoluteReturn i.e ((currDate -
     ** preDate)/preDate)*100
     * 
     * @param d1 //* preDate
     * 
     * @param d2 //* currDate
     ** 
     * @return return absoluteReturn value
     */
    public double AbsoluteReturn(String preDate, String currDate) {
        File file = new File("data/CIPLA.NS.csv");
        double absoluteReturn = 0;
        String adjClosePreDate; // * taking String value i.e preDate adj Close
        String adjCloseCurrDate; // * taking String value i.e currDate adj Close
        double dd1 = 0, dd2 = 0; // ** dd1 and dd2 are preDate and currDate data in double form */
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] stock = line.split(",");
                if (stock[0].equals(preDate)) {
                    adjClosePreDate = stock[5];
                    dd1 = Double.parseDouble(adjClosePreDate); // * dd1 prevDate data in double form
                }
                if (stock[0].equals(currDate)) {
                    adjCloseCurrDate = stock[5];
                    dd2 = Double.parseDouble(adjCloseCurrDate); // * dd2 currDate data in double form

                }
                absoluteReturn = ((dd2 - dd1) / dd2) * 100; // * formula of absoluteReturn

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return absoluteReturn;

    }

}

/**
 * * to print .csv file => File file = new File("Filename.csv"); List<String>
 * lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8); for
 * (String line : lines) { String[] array = line.split(";");
 * System.out.println(array[0]+" "+array[array.length-1]); }
 */