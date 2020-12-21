
/**
 * RobberShootout
 */
import java.util.Scanner;

public class RobberShootout {

    private static void shootRobbers(int robbers, int startShooting, int gapDistance) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int[] ans = new int[arr.length];
        int n = robbers;
        for (int i = 0, k = 0; i < n - 1; i = (i + 3) % n) {
            // System.out.print(arr[i] + " ");

            if (arr[i] == startShooting) {
                ans[k++] = i + 1;
                // startShooting = arr[i + 4];
            }

        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int robbers, startShooting, gapDistance;

        System.out.println("Enter No. of Robbers : ");
        robbers = sc.nextInt();
        System.out.println("Enter The Robber with whom Sam will start shooting: ");
        startShooting = sc.nextInt();
        System.out.println("Enter the gap between the robbers: ");
        gapDistance = sc.nextInt();
        // int[] ans =
        shootRobbers(robbers, startShooting, gapDistance);
        // display(ans);

    }
}