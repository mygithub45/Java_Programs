package Recursion;
//https://www.codingninjas.com/codestudio/problems/find-power-of-a-number_893198?source=youtube&campaign=Recursion_Fraz&utm_source=youtube&utm_medium=affiliate&utm_campaign=Recursion_Fraz
//https://github.com/LeadCoding/FrazArmy/blob/main/Recursion/Lecture%2004/CodeStudio/Find%20power%20of%20a%20number.java
public class PowerOfNumber {
    public static long Pow(int X, int N) {
        // base condition
        if(N==0) return 1;

        long temp=Pow(X,N/2); // recursion call

        // if N is odd then we will have to multiply X
        if(N%2==1) return temp*temp*X;
        return temp*temp;
    }

    public static void main(String[] args) {
        Pow(3, 5);
    }
}
/*
   time complexity : O(log n)
   space complexity : O(log n)
*/
