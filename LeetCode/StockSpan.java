package LeetCode;// Java program for brute force method
// to calculate stock span values
//https://www.geeksforgeeks.org/the-stock-span-problem/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class StockSpan {

	static ArrayList<Integer> calculateSpan(int arr[],
											int n)
	{
		// Your code here
		Deque<Integer> s = new ArrayDeque<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && arr[s.peek()] <= arr[i])
				s.pop();

			if (s.isEmpty())
				ans.add(i + 1);
			else {
				int top = s.peek();
				ans.add(i - top);
			}
			s.push(i);
		}

		return ans;
	}

	// A utility function to print elements of array
	static void printArray(ArrayList<Integer> arr)
	{
		for (int i = 0; i < arr.size(); i++)
			System.out.print(arr.get(i) + " ");
	}

	// Driver code
	public static void main(String args[])
	{
		int price[] = { 10, 4, 5, 90, 120, 80 };
		int n = price.length;

		ArrayList<Integer> arr = calculateSpan(price, n);
		printArray(arr);
	}
}

// This is code is contributed by Lovely Jain
//Time Complexity: O(N), where N is the size of the array.
//Auxiliary Space: O(N), where N is the size of the array. 