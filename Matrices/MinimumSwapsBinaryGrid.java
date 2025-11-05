// 1536. Minimum Swaps to Arrange a Binary Grid
// You can swap adjacent rows. A grid is valid when for every row i,
// all cells grid[i][j] == 0 for j > i (i.e., trailing zeros condition).
// Return minimum swaps or -1.

import java.util.*;

public class MinimumSwapsBinaryGrid {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailing = new int[n];

        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailing[i] = count;
        }

        int swaps = 0;

        // Step 2: For each row i, find a row j >= i with enough trailing zeros
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int j = i;

            // find row j that satisfies requirement
            while (j < n && trailing[j] < required) {
                j++;
            }

            // no valid row found --> impossible
            if (j == n) return -1;

            // bring row j up to i by swapping adjacent rows
            while (j > i) {
                int temp = trailing[j];
                trailing[j] = trailing[j - 1];
                trailing[j - 1] = temp;
                j--;
                swaps++;
            }
        }

        return swaps;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(minSwaps(grid));
    }
}
