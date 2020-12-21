import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class TicketImpl {

    static ArrayList readFromFile(String fileName) {
        ArrayList tickList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");

                TicketDetails td = new TicketDetails();
                td.setScheduleNo(arr[0]);
                td.setRouteNo(arr[1]);
                td.setTicketFromStopId(Integer.parseInt(arr[2]));
                td.setTicketFromStopSeqNo(Integer.parseInt(arr[3]));
                td.setTicketTillStopId(Integer.parseInt(arr[4]));
                td.setTicketTillStopSeqNo(Integer.parseInt(arr[5]));
                td.setTicketDate(arr[6]);
                td.setTicketTime(arr[7]);
                td.setTotalTicketAmount(Integer.parseInt(arr[8]));
                td.setTravelledKM(Double.parseDouble(arr[9]));

                tickList.add(td);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickList;
    }

    static void writeToFile(ArrayList readAllData) {
        try {
            ArrayList<TicketDetails> td = readAllData;
            BufferedWriter ow = null;
            ow = new BufferedWriter(new FileWriter("ans.csv"));
            for (TicketDetails t : td) {
                ow.write(t.getRouteNo() + " " + t.getScheduleNo() + " " + t.getTicketFromStopId() + " "
                        + t.getTicketFromStopSeqNo() + " " + t.getTicketTillStopId() + " " + t.getTicketTillStopSeqNo()
                        + " " + t.getTicketDate() + " " + t.getTicketTime() + " " + t.getTotalTicketAmount() + " "
                        + t.getTravelledKM());
                ow.newLine();
            }
            ow.flush();
            ow.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ArrayList<TicketDetails> readAllData = readFromFile("ticketingdata.csv");

        Comparator<TicketDetails> comp = new Comparator<TicketDetails>() {
            public int compare(TicketDetails o1, TicketDetails o2) {
                return o1.getRouteNo().compareTo(o2.getRouteNo()); // Comapre String

            }
        };
        Collections.sort(readAllData, comp);
        writeToFile(readAllData);
        int totalAmount = 0, c = 0;
        for (TicketDetails t : readAllData) {
            totalAmount += t.getTotalTicketAmount();
            c++;
        }
        System.out.println("The average total ticket amount collected : " + totalAmount / c);
    }
}
