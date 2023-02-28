package LeetCode;// Java program to check if given array
// has 2 elements whose sum is equal
// to the given value
import java.util.*;
//https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
class TwoSumWithO1SpaceComplexity {

	static boolean binarySearch(int A[], int low, int high,
								int searchKey)
	{

		while (low <= high) {
			int m = low + (high - low) / 2;

			// Check if searchKey is present at mid
			if (A[m] == searchKey)
				return true;

			// If searchKey greater, ignore left half
			if (A[m] < searchKey)
				low = m + 1;

			// If searchKey is smaller, ignore right half
			else
				high = m - 1;
		}

		// if we reach here, then element was
		// not present
		return false;
	}

	static boolean checkTwoSum(int A[], int arr_size,
							int sum)
	{
		int l, r;

		/* Sort the elements */
		Arrays.sort(A);

		// Traversing all element in an array search for
		// searchKey

		for (int i = 0; i < arr_size - 1; i++) {

			int searchKey = sum - A[i];

			if (binarySearch(A, i + 1, arr_size - 1,
							searchKey)
				== true) {
				return true;
			}
		}

		return false;
	}

	// Driver code
	public static void main(String args[])
	{
		int A[] = { 1, 4, 45, 6, 10, -8 };
		int n = 14;
		int arr_size = A.length;

		// Function calling
		if (checkTwoSum(A, arr_size, n))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
//Time Complexity: O(NlogN)
//Auxiliary Space: O(1)