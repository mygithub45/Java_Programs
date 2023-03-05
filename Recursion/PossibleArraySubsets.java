package Recursion;
import java.util.*;
//https://www.youtube.com/watch?v=0N3RCWa8jFM&list=PLjkkQ3iH4jy82KRn9jXeFyWzvX7sqYrjE&index=8
//https://github.com/LeadCoding/FrazArmy/blob/main/Recursion/Lecture%2007/CodeStudio/Power%20Set.java
//https://www.codingninjas.com/codestudio/problems/power-set_1062667?source=youtube&campaign=Recursion_Fraz&utm_source=youtube&utm_medium=affiliate&utm_campaign=Recursion_Fraz
public class PossibleArraySubsets {

    public static void main(String[] args) {
        ArrayList<Integer> inputList= new ArrayList<>(Arrays. asList(1, 2, 3));

        System.out.println("all possible subsets:"+pwset(inputList));
    }
    static void helper(ArrayList<Integer> v, int i, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> ans)
    {
        // base condition

        if (i == v.size())
        {
            ans.add(new ArrayList(subSet));
            return;
        }

        // pick the ith element

        subSet.add(v.get(i));
        helper(v, i + 1, subSet, ans);

        // backtrack & undo the changes that were made

        subSet.remove(subSet.size()-1);

        // skip the ith element

        helper(v, i + 1, subSet, ans);
    }
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subSet = new ArrayList<>();
        helper(arr, 0, subSet, ans);
        return ans;
    }
}
/*
    time complexity : O(2^n)
    space complexity : O(n)
*/