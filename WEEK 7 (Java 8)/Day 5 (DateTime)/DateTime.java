import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * DateTime
 */
public class DateTime {

    public static void main(String[] args) {
        LocalDate todaysDate = LocalDate.now();
        System.out.println(todaysDate);

        todaysDate = LocalDate.of(2020, 12, 18);
        LocalDate randomDate = LocalDate.parse("2020-02-09");
        // D MM YYYY
        System.out.println(randomDate.format(DateTimeFormatter.ofPattern("d-MMM-uu")));
        // their are various format, see the java documentation

        LocalDate holiday = LocalDate.parse("2020-08-15");

        LocalDate leaveEmp = LocalDate.parse("2020-09-10");

        System.out.println(leaveEmp.isAfter(holiday));
        System.out.println(leaveEmp.isBefore(holiday));
        Period period = Period.between(holiday, leaveEmp);

        System.out.println(period.getDays());

        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);
        LocalTime.of(3, 20, 0);

        LocalTime us = LocalTime.now(ZoneId.of("America/Nuuk"));
        System.out.println(us);

    }
}