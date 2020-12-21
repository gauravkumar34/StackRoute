package Seaching;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int searchElement = 100;
        boolean ans = isBinarySearch(arr, searchElement);
        System.out.println(ans);
    }

    private static boolean isBinarySearch(int[] arr, int searchElement) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == searchElement)
                return true;
            else if (searchElement > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }

}
