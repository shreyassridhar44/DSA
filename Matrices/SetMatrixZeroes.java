// 73. Set Matrix Zeroes
// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0s.
// Must do it in-place (constant space).

import java.util.*;

public class SetMatrixZeroes {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Time Complexity: O((m*n)*(m+n))
    // Space Complexity: O(1)
    // Marks zeros using a temporary marker (-1)
    public static void setZeroesBrute(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i, n);
                    markCol(matrix, j, m);
                }
            }
        }

        // replace all -1 with 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }

    private static void markRow(int[][] matrix, int row, int n) {
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] != 0)
                matrix[row][j] = -1;
        }
    }

    private static void markCol(int[][] matrix, int col, int m) {
        for (int i = 0; i < m; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = -1;
        }
    }

    // ---------------- OPTIMAL APPROACH ----------------
    // Time Complexity: O(m * n)
    // Space Complexity: O(1)
    // Logic: Use the first row & column as markers.
    public static void setZeroesOptimal(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstColZero = false;

        // Step 1: Mark rows and columns
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColZero = true;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Set zeroes based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Step 3: Handle first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

        // Step 4: Handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Uncomment one approach to run
        // setZeroesBrute(matrix);
        setZeroesOptimal(matrix);

        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}
