package LeetCode;// Java program for Boggle game
import java.util.*;
//https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
//https://www.geeksforgeeks.org/boggle-using-trie/
public class BoggleGame {
	private static final int M = 3;
	private static final int N = 3;

	private static boolean dfs(char[][] board, String s, int i, int j, int n, int m, int idx) {
		if (i < 0 || i >= n || j < 0 || j >= m) {
			return false;
		}
		if (s.charAt(idx) != board[i][j]) {
			return false;
		}
		if (idx == s.length() - 1) {
			return true;
		}
		char temp = board[i][j];
		board[i][j] = '*';

		boolean a = dfs(board, s, i, j + 1, n, m, idx + 1);
		boolean b = dfs(board, s, i, j - 1, n, m, idx + 1);
		boolean c = dfs(board, s, i + 1, j, n, m, idx + 1);
		boolean d = dfs(board, s, i - 1, j, n, m, idx + 1);
		boolean e = dfs(board, s, i + 1, j + 1, n, m, idx + 1);
		boolean f = dfs(board, s, i - 1, j + 1, n, m, idx + 1);
		boolean g = dfs(board, s, i + 1, j - 1, n, m, idx + 1);
		boolean h = dfs(board, s, i - 1, j - 1, n, m, idx + 1);

		board[i][j] = temp;
		return a || b || c || e || f || g || h || d;
	}

	private static void wordBoggle(char[][] board, String[] dictionary) {
		int n = board.length;
		int m = board[0].length;
		Set<String> ans = new HashSet<>();
		Set<String> store = new HashSet<>();
		for (String s : dictionary) {
			int l = s.length();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (dfs(board, s, i, j, n, m, 0)) {
						store.add(s);
					}
				}
			}
		}
		for (String i : store) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		char[][] boggle = {
			{'G', 'I', 'Z'},
			{'U', 'E', 'K'},
			{'Q', 'S', 'E'}
		};
		// Let the given dictionary be following
		String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

		System.out.println("Following words of dictionary are present");
		wordBoggle(boggle, dictionary);
	}
}

// This code is contributed by shivamsharma215
//Time Complexity: O(N*W + R*C^2)
//
//Auxiliary Space: O(N*W + R*C)