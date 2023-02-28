package LeetCode;/* Java program to Check if a given array contains duplicate
elements within k distance from each other */
import java.util.*;
//https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
class DuplicatesinKDistance
{
	/* Java program to Check if a given array contains
    duplicate elements within k distance from each other */
	public static boolean
	checkDuplicatesWithinK(int[] arr, int n, int k)
	{

		// traversing the input array
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int range = k;
			// searching in next k-1 elements if its
			// duplicate is present or not
			while (range > 0 && j < n) {
				if (arr[i] == arr[j]) {
					return true;
				}
				j++;
				range--;
			}
		}
		return false;
	}

	// Driver method to test above method
	public static void main(String[] args)
	{
		int[] arr = { 10, 5, 3, 4, 3, 5, 6 };
		int n = arr.length;
		if (checkDuplicatesWithinK(arr, n, 3)) {
			System.out.print("Yes");
		}
		else {
			System.out.print("No");
		}
	}
}
//Time Complexity: O(N*K).
//Auxiliary Space: O(1).