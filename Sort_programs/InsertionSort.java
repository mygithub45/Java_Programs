import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2,12,15,8,100,76,43,87,6,9};
        long start = System.currentTimeMillis();
        insertion(arr);
        System.out.println(Arrays.toString(arr));

        // ending time
        long end = System.currentTimeMillis();
        System.out.println("time taken " +
                (end - start) + "ms");
    }

    static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
