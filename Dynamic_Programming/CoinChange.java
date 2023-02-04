package Programs;
//https://www.geeksforgeeks.org/coin-change-dp-7/
//https://www.youtube.com/watch?v=jaNZ83Q3QGc
/*
Given an integer array of coins[ ] of size N representing different types of currency and an integer sum,
 The task is to find the number of ways to make sum by using different combinations from coins[].
 */
import java.util.Arrays;
public class CoinChange {
/* Dynamic Programming Java implementation of Coin
Change problem */



        static long count(int coins[], int n, int sum)
        {
            // table[i] will be storing the number of solutions for
            // value i. We need sum+1 rows as the table is
            // constructed in bottom up manner using the base case
            // (sum = 0)
            int table[] = new int[sum + 1];

            // Base case (If given value is 0)
            table[0] = 1;

            // Pick all coins one by one and update the table[]
            // values after the index greater than or equal to the
            // value of the picked coin
            for (int i = 0; i < n; i++)
                for (int j = coins[i]; j <= sum; j++)
                    table[j] += table[j - coins[i]];

            return table[sum];
        }

        // Driver Function to test above function
        public static void main(String args[])
        {
            int coins[] = { 1, 2, 3 };
            int n = coins.length;
            int sum = 4;
            System.out.println(count(coins, n, sum));
        }
    }
// This code is contributed by Pankaj Kumar

//Time Complexity: O(N*sum)
//Auxiliary Space: O(sum)
