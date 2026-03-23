/*
LeetCode 162: Find Peak Element

Problem:
A peak element is strictly greater than its neighbors.

Return index of any peak element.

Constraints:
Time Complexity must be O(log n)

Example:
Input: [1,2,3,1]
Output: 2
*/

public class FindPeakElement {

    // ---------------------------------------------------
    // Brute Force Approach
    // Check every element
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean left = (i == 0) || (nums[i] > nums[i - 1]);
            boolean right = (i == n - 1) || (nums[i] > nums[i + 1]);

            if (left && right) {
                return i;
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search (slope-based)
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // increasing slope → peak on right
                low = mid + 1;
            } else {
                // decreasing slope → peak on left (including mid)
                high = mid;
            }
        }

        return low; // or high (both same)
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println("Brute Force: " + bruteForce(nums));
        System.out.println("Optimal Approach: " + optimalApproach(nums));
    }
}