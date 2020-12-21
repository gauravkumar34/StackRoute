import java.util.Scanner;

public class classW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Rating : ");
        float rating = sc.nextFloat();
        printRating(rating);

    }

    public static void printRating(float rating) {
        if (rating > 4.5) {
            System.out.println("Excellent");
        } else if (rating <= 4.5 && rating >= 3.8) {
            System.out.println("Good");
        } else if (rating < 3.8 && rating >= 3) {
            System.out.println("Average");
        } else {
            System.out.println("Poor");
        }
    }
}
