/*
LeetCode 74: Search a 2D Matrix

Problem:
Given a matrix where:
- Each row is sorted
- First element of each row > last element of previous row

Return true if target exists, else false.

Example:
Input:
matrix = [[1,3,5,7],
          [10,11,16,20],
          [23,30,34,60]]
target = 3

Output: true
*/

public class Search2DMatrix {

    // ---------------------------------------------------
    // Brute Force Approach
    // Traverse entire matrix
    // Time Complexity: O(m * n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static boolean bruteForce(int[][] matrix, int target) {

        for (int[] row : matrix) {
            for (int num : row) {
                if (num == target) {
                    return true;
                }
            }
        }

        return false;
    }


    // ---------------------------------------------------
    // Optimal Approach (Your Logic)
    // Step 1: Find correct row using binary search
    // Step 2: Search inside row using binary search
    // Time Complexity: O(log m + log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static boolean optimalApproach(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int row = -1;

        // Step 1: Find the correct row
        while (top <= bottom) {

            int mid = top + (bottom - top) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                row = mid;
                break;
            } 
            else if (target > matrix[mid][0]) {
                top = mid + 1;
            } 
            else {
                bottom = mid - 1;
            }
        }

        if (row == -1) return false;

        // Step 2: Binary search in that row
        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } 
            else if (matrix[row][mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return false;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3;

        System.out.println("Brute Force: " + bruteForce(matrix, target));
        System.out.println("Optimal Approach: " + optimalApproach(matrix, target));
    }
}