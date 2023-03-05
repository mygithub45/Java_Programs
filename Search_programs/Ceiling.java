package Search_programs;

public class Ceiling {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        int ans = ceiling(arr, target);
        int target1 = 25;
        int ans1 = ceiling(arr, target1);
         if(ans > 0)
             System.out.println("ceiling of given target is at index:" + ans + " and the value is :" + arr[ans]);
         else
             System.out.println("Ceiling cant be found as its above the range of array");
    }

    // return the index of smallest no >= target
    static int ceiling(int[] arr, int target) {

        // but what if the target is greater than the greatest number in the array
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return start;
    }

}