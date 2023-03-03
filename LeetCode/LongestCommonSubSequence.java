package LeetCode;
//https://github.com/neetcode-gh/leetcode/blob/main/java/1143-longest-common-subsequence.java
//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        //O(n*m)/O(n*m)  time/memory
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
    // Drivers code
    public static void main(String args[]){

        String X = "AGGTAB";
        String Y = "GXTXAYB";

       /* int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<m + 1;i++){
            for(int j=0;j<n + 1;j++){
                dp[i][j] = -1;
            }
        }*/

        System.out.println("Length of LCS is "+longestCommonSubsequence(X, Y));

    }
}

//Time Complexity: O(m*n) which is much better than the worst-case time complexity of Naive Recursive implementation.
//Auxiliary Space: O(m*n) because the algorithm uses an array of size (m+1)*(n+1) to store the length of the common substrings.