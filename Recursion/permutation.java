package Recursion;
import java.util.*;

//https://github.com/LeadCoding/FrazArmy/blob/main/Recursion/Lecture%2008/LeetCode/Permutations.java
//https://www.codingninjas.com/codestudio/problems/permutations-of-a-string_985254?source=youtube&campaign=Recursion_Fraz&utm_source=youtube&utm_medium=affiliate&utm_campaign=Recursion_Fraz
//https://www.youtube.com/watch?v=jRyQVVvYBAM&list=PLjkkQ3iH4jy82KRn9jXeFyWzvX7sqYrjE&index=9
public class permutation {
    public static void main(String[] args) {
        int[] inputArr=new int[]{1, 2, 3};

        System.out.println("all possible permutations:");
        List<List<Integer>> permlist=     permute(inputArr);
        iterateUsingForEach(permlist);
    }
    public static <K> void
    iterateUsingForEach(List<List<K> > listOfLists)
    {

        // Iterate the 2D list
        // and print each element
        System.out.println("[");

        for (List<K> list : listOfLists) {
            System.out.print("  [");

            for (K item : list) {
                System.out.print("  "
                        + item
                        + ", ");
            }
            System.out.println("], ");
        }
        System.out.println("]");
    }

    public static void helper(int pos , int n , int[] nums , List<List<Integer>> ans)
    {
        // If we have reached the end of nums, we have found a Valid Permutations of nums

        if(pos >= n)
        {
            List<Integer> permutation = ConverttoList(nums);
            ans.add(new ArrayList(permutation)) ;
            return ;
        }

        // Otherwise we iterate over all the other elements and try to generate Permutations by swapping element at pos with element at i

        for(int i = pos ; i < n ; i++)
        {
            // We create one Unique Permutation by swapping

            swap(pos , i, nums) ;

            // And we ask Recursion to handle rest of the task

            helper(pos + 1 , n , nums , ans) ;

            // But after we come back, we must backtrack and undo the changes we have done

            swap(pos , i, nums) ;
        }

        return ;
    }

    public static void swap (int i, int j, int[] nums)
    {
        // Swaping the elements

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<Integer> ConverttoList(int[] nums)
    {
        // Converting the array into List

        List<Integer> ans = new ArrayList<>();
        for(int ele : nums)
            ans.add(ele);
        return ans;
    }

    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();

        helper(0 , nums.length , nums , ans) ;

        return ans ;
    }
}

/*
Time Complexity  : O(N * N!)
Space Complexity : O(N)
*/

