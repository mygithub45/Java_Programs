package LeetCode;

class WordSearch {
   // static int R, C;
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, word, i, j, m, n, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(
        char[][] board,
        String word,
        int i,
        int j,
        int m,
        int n,
        int cur
    ) {
        if (cur >= word.length()) return true;
        if (
            i < 0 ||
            j < 0 ||
            i >= m ||
            j >= n ||
            board[i][j] != word.charAt(cur)
        ) return false;
        boolean exist = false;
        if (board[i][j] == word.charAt(cur)) {
            board[i][j] += 100;
            exist =
                check(board, word, i + 1, j, m, n, cur + 1) ||
                check(board, word, i, j + 1, m, n, cur + 1) ||
                check(board, word, i - 1, j, m, n, cur + 1) ||
                check(board, word, i, j - 1, m, n, cur + 1);
            board[i][j] -= 100;
        }
        //System.out.println("i="+i+"j="+j);
        return exist;
    }

    // Driver code
    public static void main(String args[])
    {
        /*R = 3;
        C = 13;*/
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
        //exist(grid, "GEEKS");
        System.out.println();
        System.out.println("pattern exists:"+exist(grid, "EEE"));
    }
}
