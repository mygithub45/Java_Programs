package Programs;
//https://www.enjoyalgorithms.com/blog/minimum-coin-change/

//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
public class MinimumCoinChange {
    // A Dynamic Programming based Java
// program to find minimum of coins
// to make a given change V

        // m is size of coins array
        // (number of different coins)
        static int minCoins(int coins[], int m, int V)
        {
            // table[i] will be storing
            // the minimum number of coins
            // required for i value. So
            // table[V] will have result
            int table[] = new int[V + 1];

            // Base case (If given value V is 0)
            table[0] = 0;

            // Initialize all table values as Infinite
            for (int i = 1; i <= V; i++)
                table[i] = Integer.MAX_VALUE;

            // Compute minimum coins required for all
            // values from 1 to V
            for (int i = 1; i <= V; i++)
            {
                // Go through all coins smaller than i
                for (int j = 0; j < m; j++)
                    if (coins[j] <= i)
                    {
                        int sub_res = table[i - coins[j]];
                        if (sub_res != Integer.MAX_VALUE
                                && sub_res + 1 < table[i])
                            table[i] = sub_res + 1;


                    }

            }

            if(table[V]==Integer.MAX_VALUE)
                return -1;

            return table[V];

        }

        // Driver program
        public static void main (String[] args)
        {
            int coins[] = {9, 6, 5, 1};
            int m = coins.length;
            int V = 11;
            System.out.println ( "Minimum coins required is "
                    + minCoins(coins, m, V));

            int coins1[] = {1,3,5,7};
            int m1 = coins.length;
            int V1 = 18;
            System.out.println ( "Minimum coins required is "
                    + minCoins(coins1, m1, V1));
        }
    }
/*
Time complexity: O(m*V).
Auxiliary space: O(V) because using extra space for array table
 */



