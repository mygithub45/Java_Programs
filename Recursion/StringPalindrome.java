package Recursion;

//https://www.youtube.com/watch?v=m5Cx_AQnpfE&list=PLjkkQ3iH4jy82KRn9jXeFyWzvX7sqYrjE&index=6&t=2s
//https://www.codingninjas.com/codestudio/problems/check-palindrome_4219630?source=youtube&campaign=Recursion_Fraz&utm_source=youtube&utm_medium=affiliate&utm_campaign=Recursion_Fraz&leftPanelTab=0

//https://github.com/LeadCoding/FrazArmy/tree/main/Recursion/Lecture%2005/CodeStudio
public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println("given string  RADAR is palindrome?"+isPalindrome("RADAR"));
        System.out.println("given string  APXEA is palindrome?"+isPalindrome("APXEA"));
    }
    static Boolean helper(int l, int r, String s){
        // base condition
        // l : left pointer, r : right pointer
        if(l>=r) return true;

        // base condition
        // when character at s[left] is not equal to character at s[right] that means it is not a palindrome thus return false
        if(s.charAt(l)!=s.charAt(r)) return false;

        // recursion call
        return helper(l+1,r-1,s);
    }

    public static Boolean isPalindrome(String s) {
        // Write your code here..
        // here we are going to use two pointer approach
        // left pointer starting from first index 0
        // right pointer starting from last index s.size() - 1
        return helper(0,s.length()-1,s);
    }
}
/*
    time complexity : O(n)
    space complexity : O(n)
*/