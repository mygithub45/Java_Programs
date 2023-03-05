package LinkedList;

public class HappyNumber {
// https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/18-linkedlist/code/src/com/kunal/InterviewQuestions.java
// Google: https://leetcode.com/problems/happy-number/
// we will use linkedlist cycle theory
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    private static int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
    System.out.println("Given number 19 is a happy number:"+HappyNumber.isHappy(19));

    }
}
