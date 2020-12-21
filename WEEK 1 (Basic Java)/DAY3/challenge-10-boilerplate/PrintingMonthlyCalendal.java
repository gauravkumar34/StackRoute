import java.util.Scanner;

public class PrintingMonthlyCalendal {
    /**
     * This function return maximum date of the month and checking the year is leap
     * year or not.
     * 
     * @param month
     * @param year
     * @return
     */
    int findMaxDay(int month, int year) {
        String[] months = { "", "Jan", "Fab", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        int[] Days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // ! Cheacking leap year or not

        if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
            Days[2] = 29;
        }
        int max = 0;
        for (int i = 0; i < 12; i++) {
            if (month == i) {
                max = Days[i];
            }
        }
        return max;

    }

    /**
     * This function is to filling the structure of calender acc. to their year and
     * day;
     * 
     * @param max
     * @param day
     * @param year
     */

    void fillCalendar(int max, int day, int year) {
        int A[][] = new int[6][7];
        int x = 1, z = day;

        for (int i = 0; i < 6; i++) {
            for (int j = day; j < 7; j++) {
                if (x <= max) {
                    A[i][j] = x;
                    x++;
                }
            }
            day = 0;
        }
        for (int j = 0; j < z; j++) {
            A[0][j] = A[5][j];
        }
        printCalendar(A, year);
    }

    /**
     * this function printing the Calender
     * 
     * @param A    taking no of day in array
     * @param year
     */
    void printCalendar(int A[][], int year) {
        System.out.println("\t----------------------------------------------------");
        System.out.println("\tSUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
        System.out.println("\t----------------------------------------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (A[i][j] != 0)
                    System.out.print("\t " + A[i][j]);
                else
                    System.out.print("\t ");
            }
            System.out.println("\n");
        }

    }

    public static void main(String[] args) {
        PrintingMonthlyCalendal ob = new PrintingMonthlyCalendal();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month(Press 1 for Jan, 2 for Feb, 12 for Dec......): ");
        int month = sc.nextInt();
        System.out.println("Enter Year:");
        int year = sc.nextInt();
        System.out.println("Enter Day of week(Press 1 for Mon, 2 for Tue, 7 for Sun......):");
        int day = sc.nextInt();

        int max = ob.findMaxDay(month, year);
        ob.fillCalendar(max, day, year);
    }
}
