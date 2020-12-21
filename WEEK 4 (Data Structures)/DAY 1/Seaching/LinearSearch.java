package Seaching;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = { 5, 42, 1, 2, 78, 45, 33, 9, 3 };
        int searchElement = 45;
        boolean a = linearSearch(arr, searchElement);
        System.out.println(a);
    }

    private static boolean linearSearch(int[] arr, int searchElement) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchElement) {
                return true;
            }
        }
        return false;
    }

}