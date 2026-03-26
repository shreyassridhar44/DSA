/*
LeetCode 240: Search a 2D Matrix II

Problem:
Each row is sorted (left → right)
Each column is sorted (top → bottom)

Find if target exists.

Example:
Input:
matrix =
[
 [1,4,7,11,15],
 [2,5,8,12,19],
 [3,6,9,16,22],
 [10,13,14,17,24],
 [18,21,23,26,30]
]
target = 5

Output: true
*/

public class Search2DMatrixII {

    // ---------------------------------------------------
    // Brute Force Approach
    // Traverse all elements
    // Time Complexity: O(m * n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static boolean bruteForce(int[][] matrix, int target) {

        for (int[] row : matrix) {
            for (int num : row) {
                if (num == target) return true;
            }
        }

        return false;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Start from top-right corner
    // Time Complexity: O(m + n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static boolean optimalApproach(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {

            int current = matrix[row][col];

            if (current == target) {
                return true;
            }
            else if (current > target) {
                col--; // move left
            }
            else {
                row++; // move down
            }
        }

        return false;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };

        int target = 5;

        System.out.println("Brute Force: " + bruteForce(matrix, target));
        System.out.println("Optimal Approach: " + optimalApproach(matrix, target));
    }
}