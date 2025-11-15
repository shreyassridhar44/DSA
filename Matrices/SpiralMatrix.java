// 54. Spiral Matrix
// Return all elements of a matrix in spiral order.

import java.util.*;

public class SpiralMatrix {

    // Time Complexity: O(m * n)
    // Space Complexity: O(1) extra (excluding output list)
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            // 1. Traverse Left → Right
            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;

            // 2. Traverse Top → Bottom
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            // 3. Traverse Right → Left (only if rows remain)
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
                bottom--;
            }

            // 4. Traverse Bottom → Top (only if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }

    // MAIN FUNCTION (Handles User Input)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}
