package Sort_programs;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/
// Amazon Question
//Based on cyclic sort
class MissingNumberInRange {

    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        System.out.println("Missing number in  "+ Arrays.toString(arr)+" is "+ missingNumber(arr));
        int[] arr1 = {1,0,3,2};
        System.out.println("Missing number in  "+ Arrays.toString(arr1)+" is "+ missingNumber(arr1));
    }

    public static int missingNumber(int[] arr) {
        int i = 0;
        //sort the given array
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }

        // case 2
        return arr.length;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
