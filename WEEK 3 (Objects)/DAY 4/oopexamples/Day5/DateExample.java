import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = sdf.format(date);  
        System.out.println("Date in the format of MM-dd-yyyy : "+dateString);  
    }
}
