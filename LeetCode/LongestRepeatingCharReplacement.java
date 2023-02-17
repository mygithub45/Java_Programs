package LeetCode;
//https://github.com/neetcode-gh/leetcode/blob/main/java/0424-longest-repeating-character-replacement.java
//https://www.youtube.com/watch?v=gqXU1UyA8pk
class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
    public static void main(String[] s)
    {
        System.out.println(characterReplacement("ABABBA",2));
    }
}