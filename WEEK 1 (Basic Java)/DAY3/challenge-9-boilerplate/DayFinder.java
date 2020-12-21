import java.util.Scanner;

public class DayFinder {

    /**
     * This Function calculate the day after current Day to Desire Day
     * 
     * @param currentDay taking current day
     * @param desireDay  taking desire day
     * @param week       array having days from Mon to Sun
     */
    public static void dayAfterFromToday(int currentDay, int desireDay, String[] week) {
        for (int i = 1; i <= week.length; i++) {
            // wantDay are variable which is adding the current day and desire day.
            int wantDay;
            wantDay = currentDay + desireDay;
            wantDay = (wantDay % 7);
            if (wantDay == i) {
                System.out.println(week[i - 1]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the current day of week(For Monday Enter 1, Tuesday, Enter 2 and so on)");
        int currentDay = sc.nextInt();

        System.out.println("Enter the no. of days from today:");
        int desireDay = sc.nextInt();
        String[] week = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        dayAfterFromToday(currentDay, desireDay, week);

    }
}
