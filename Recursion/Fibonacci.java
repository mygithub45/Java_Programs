package Recursion;
// https://github.com/LeadCoding/FrazArmy/blob/main/Recursion/Lecture%2003/LeetCode/Fibonacci%20Number.java

// https://www.youtube.com/watch?v=2l3cSfE885g&list=PLjkkQ3iH4jy8_6dT3hGGoj6liE-0j_9mH&index=3
/*
    time complexity : O(2^n) no of nodes in the tree
    space complexity : O(n) height of the tree
*/
public class Fibonacci {
    public int fib(int n) {
    // base condition
        if(n==0)
            return 0;
		if(n==1 || n==2)
            return 1;

    // recursion call that will return (n-1)th & (n-2)th fibo number which will then be added to give us the nth fibo number
		return fib(n-1)+fib(n-2);
}
}
