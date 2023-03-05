package Recursion;
import java.util.ArrayList;
import java.util.Collections;
//https://www.youtube.com/watch?v=quqHd8UHbzs&list=PLjkkQ3iH4jy82KRn9jXeFyWzvX7sqYrjE&index=7
//https://www.codingninjas.com/codestudio/problems/reverse-the-array_1262298?source=youtube&campaign=Recursion_Fraz&utm_source=youtube&utm_medium=affiliate&utm_campaign=Recursion_Fraz
//https://github.com/LeadCoding/FrazArmy/blob/main/Recursion/Lecture%2006/CodeStudio/Reverse%20The%20Array.java
public class ReverseArray {
    static int helper(int l, int r,ArrayList<Integer> arr){
        // base condition
        if(l>=r) return 1;

        // do the small task
        Collections.swap(arr, l, r);

        // ask recursion to do the remaining task
        return helper(l+1,r-1,arr);
    }
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Write your code here.
        helper(m+1,arr.size()-1,arr);
    }
}
/*
    time complexity : O(n)
    space complexity : O(n)
*/