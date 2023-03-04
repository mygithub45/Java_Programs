package LeetCode;// Java program for the above approach
import java.util.*;
//https://www.geeksforgeeks.org/find-non-overlapping-intervals-among-a-given-set-of-intervals/
class NonOverlappingIntervals {
	
// Interval with start time & end time
static class Interval
{
	int start, end;

	Interval(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
}

// Function that find the free interval
static void findFreeinterval(int[][] arr, int N)
{
	// If there are no set of interval
	if (N <= 0)
	{
		return;
	}

	// To store the set of free interval
	ArrayList<Interval> p = new ArrayList<>();

	// Sort the given interval according
	// starting time
	Arrays.sort(arr, new Comparator<int[]>()
	{
		public int compare(int[] a, int[] b)
		{
			return a[0] - b[0];
		}
	});

	// Iterate over all the interval
	for (int i = 1; i < N; i++)
	{

		// Previous interval end
		int prevEnd = arr[i - 1][1];

		// Current interval start
		int currStart = arr[i][0];

		// If ending index of previous
		// is less than starting index
		// of current, then it is free
		// interval
		if (prevEnd < currStart)
		{
			Interval interval = new Interval(prevEnd,
											currStart);
			p.add(interval);
		}
	}

	// Print the free interval
	for (int i = 0; i < p.size(); i++)
	{
		System.out.println("[" + p.get(i).start +
						", " + p.get(i).end + "]");
	}
}

// Driver code
public static void main(String[] args)
{

	// Given set of interval
	int[][] arr = { { 1, 3 },
					{ 2, 4 },
					{ 3, 5 },
					{ 7, 9 } };

	int N = arr.length;

	// Function Call
	findFreeinterval(arr, N);
}
}

// This code is contributed by offbeat
//Time Complexity: O(N*log N), where N is the number of set of intervals.
//
//Auxiliary Space: O(N)