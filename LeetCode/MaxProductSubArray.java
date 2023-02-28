package LeetCode;/*package whatever //do not write package name here */
//https://www.youtube.com/watch?v=lXVy6YWFcRM
//https://github.com/neetcode-gh/leetcode/blob/main/java/0152-maximum-product-subarray.java
class MaxProductSubArray {
	// Java program to find Maximum Product Subarray

	// Returns the product
	// of max product subarray.
	static int maxSubarrayProduct(int nums[])
	{

		if (nums.length == 1) return nums[0];

		int res = nums[0];
		int max = 1;
		int min = 1;

		for (int n : nums) {
			int tmp = max * n;
			max = Math.max(n, Math.max(tmp, min * n));
			min = Math.min(n, Math.min(tmp, min * n));
			res = Math.max(res, max);
		}
		return res;
	}


	// Driver code
	public static void main(String args[])
	{
		int[] arr = { 1, -2, -3, 0, 7, -8, -2 };
		int n = arr.length;
		System.out.printf("Maximum Sub array product is %d",
						maxSubarrayProduct(arr));
	}
}

// This code is contributed by shinjanpatra
