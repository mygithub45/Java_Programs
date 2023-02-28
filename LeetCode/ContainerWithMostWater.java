package LeetCode;// Java code for Max
// Water Container
//https://www.geeksforgeeks.org/container-with-most-water/
class ContainerWithMostWater {

	public static int maxArea(int A[], int len)
	{
		int l = 0;
		int r = len -1;
		int area = 0;
	
		while (l < r)
		{
			// Calculating the max area
			area = Math.max(area,
						Math.min(A[l], A[r]) * (r - l));
						
			if (A[l] < A[r])
				l += 1;
				
			else
				r -= 1;
		}
		return area;
	}
	
	public static void main(String[] args)
	{
		int a[] = {1, 5, 4, 3};
		int b[] = {3, 1, 2, 4, 5};
	
		int len1 = 4;
		System.out.print( maxArea(a, len1)+"\n" );
	
		int len2 = 5;
		System.out.print( maxArea(b, len2) );
	}
}

// Time Complexity: O(n).
//As only one traversal of the array is required, so time complexity is O(n).
//Space Complexity: O(1).
//No extra space is required, so space complexity is constant.