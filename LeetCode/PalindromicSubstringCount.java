package LeetCode;
//https://github.com/neetcode-gh/leetcode/blob/main/java/0647-palindromic-substrings.java
//https://www.youtube.com/watch?v=4RACzI5-du8
class LongestPalindromicSubstring {

    public static int countSubstrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd Length
            int left = i, right = i;
            while (
                    left >= 0 &&
                            right < s.length() &&
                            s.charAt(left) == s.charAt(right)
            ) {
                result++;
                left--;
                right++;
            }
            // Even Length
            left = i;
            right = i + 1;
            while (
                    left >= 0 &&
                            right < s.length() &&
                            s.charAt(left) == s.charAt(right)
            ) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
    public static void main (String[] args)
    {


            System.out.println(countSubstrings("abbaeae"));
        System.out.println(countSubstrings("aaab"));

    }
}