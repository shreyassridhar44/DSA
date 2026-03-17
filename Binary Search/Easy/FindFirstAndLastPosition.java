/*
LeetCode 34: Find First and Last Position of Element in Sorted Array

Problem:
Given a sorted array nums, find the starting and ending position of a target value.

If target is not found, return [-1, -1].

You must achieve O(log n) time complexity.

Example:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
*/

import java.util.Arrays;

public class FindFirstAndLastPosition {

    // ---------------------------------------------------
    // Brute Force Approach
    // Linear scan
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int[] bruteForce(int[] nums, int target) {

        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {

                if (first == -1) {
                    first = i;
                }

                last = i;
            }
        }

        return new int[]{first, last};
    }


    // ---------------------------------------------------
    // Better Approach
    // Binary Search twice (clean separation)
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int[] betterApproach(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

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
    // Optimal Approach
    // Using lower bound & upper bound pattern
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int[] optimalApproach(int[] nums, int target) {

        int lb = lowerBound(nums, target);

        // target not present
        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        int ub = upperBound(nums, target) - 1;

        return new int[]{lb, ub};
    }

    private static int lowerBound(int[] nums, int target) {

        int left = 0, right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int upperBound(int[] nums, int target) {

        int left = 0, right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println("Brute Force: " + Arrays.toString(bruteForce(nums, target)));
        System.out.println("Better Approach: " + Arrays.toString(betterApproach(nums, target)));
        System.out.println("Optimal Approach: " + Arrays.toString(optimalApproach(nums, target)));
    }
}
