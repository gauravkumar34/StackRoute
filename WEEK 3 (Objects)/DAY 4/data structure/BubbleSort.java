public class BubbleSort {

    /**
     * * bubble Sort , time Complex : O(n^2)
     * 
     * @param arr
     */
    static void bSort(int arr[]) {
        long start = System.currentTimeMillis();
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nSorted Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println("\n\nTime in milli second  :" + (end - start));

    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 4, 3, 6, 8 };
        bSort(arr);

    }
}
