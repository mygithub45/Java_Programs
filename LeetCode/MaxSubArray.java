package LeetCode;
//https://www.youtube.com/watch?v=5WZl3MMT0Eg
//https://github.com/neetcode-gh/leetcode/blob/main/java/0053-maximum-subarray.java
//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            sum += n;
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String s[])
    {
        int  nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
