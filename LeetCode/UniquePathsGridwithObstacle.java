package LeetCode;// Java code to find number of unique paths
// in a Matrix
import java.util.*;
//https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
public class UniquePathsGridwithObstacle {
	public static void main(String[] args)
	{
		int[][] A
			= { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(uniquePathsWithObstacles(A));
	}

	public static int uniquePathsWithObstacles(int[][] A)
	{
		int r = A.length;
		int c = A[0].length;
		// create a 2D-matrix and initializing
		// with value 0
		int[][] paths = new int[][]{new int[r]};

		for (int i = 0; i < r; i++) {
			Arrays.fill(paths[i], -1);
		}

		return UniquePathHelper(0, 0, r, c, A, paths);
	}

	public static int UniquePathHelper(int i, int j, int r,
									int c, int[][] A,
									int[][] paths)
	{
		// boundary condition or constraints
		if (i == r || j == c) {
			return 0;
		}
		else if (A[i][j] == 1) {
			return 0;
		}
		// base case
		else if (i == r - 1 && j == c - 1) {
			return 1;
		}
		else if (paths[i][j] != -1) {

			return paths[i][j];
		}
		else {
			return paths[i][j]
				= UniquePathHelper(i + 1, j, r, c, A, paths)
				+ UniquePathHelper(i, j + 1, r, c, A,
									paths);
		}
	}
}

// This code is contributed by Tapesh(tapeshdua420)
