package Sort_programs;

import java.util.Arrays;

// https://leetcode.com/problems/first-missing-positive/
//Based on cyclic sort
public class MissingPositive {
    public static void main(String[] args) {
        int[] arr = {4,3,-1,1};
        System.out.println("Missing first positive number in  "+ Arrays.toString(arr)+" is "+ firstMissingPositive(arr));
        int[] arr1 = {7,8,9,11,12};
        System.out.println("Missing first positive number in  "+ Arrays.toString(arr1)+" is "+ firstMissingPositive(arr1));
        int[] arr2 = {1,2,0};
        System.out.println("Missing first positive number in  "+ Arrays.toString(arr2)+" is "+ firstMissingPositive(arr2));

    }
    public static int firstMissingPositive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            //ignore negative elements and greater than length of array -extra condition  arr[i] > 0  to cyclic sort
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
        }

        // case 2
        return arr.length + 1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}