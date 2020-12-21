public class QuickSort {
    public static void main(String[] args) {
        // 1. sort
        int[] arr = { 7, 9, 1, 4, 6, 9, 43 };
        System.out.println("\nUnsorted Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array : ");
        printQuick(arr);

    }

    private static void printQuick(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {

            int partition = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, partition - 1);
            quickSort(arr, partition + 1, endIndex);
        }

    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < pivot) {
                swap(arr, startIndex, i);
                startIndex++;
            }
        }
        swap(arr, startIndex, endIndex);
        return startIndex;
    }

    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
