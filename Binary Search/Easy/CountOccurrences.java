/*
Problem: Count Occurrences in Sorted Array

Using the logic of finding first and last occurrence.

Count = lastIndex - firstIndex + 1

If element not found → return 0

Example:
Input: arr = [1,2,2,2,3,4], x = 2
Output: 3
*/

public class CountOccurrences {

    // ---------------------------------------------------
    // Brute Force Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int[] nums, int target) {

        int count = 0;

        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }


    // ---------------------------------------------------
    // Optimal Approach (Using your logic)
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] nums, int target) {

        int first = findFirst(nums, target);

        // element not found
        if (first == -1) {
            return 0;
        }

        int last = findLast(nums, target);

        return last - first + 1;
    }


    // Find First Occurrence
    private static int findFirst(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1; // move left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }


    // Find Last Occurrence
    private static int findLast(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1; // move right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 2, 3, 4};
        int target = 2;

        System.out.println("Brute Force: " + bruteForce(nums, target));
        System.out.println("Optimal Approach: " + optimalApproach(nums, target));
    }
}