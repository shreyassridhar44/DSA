/*
Problem: Floor and Ceil in Sorted Array

Given a sorted array arr[] and an integer x,
find:
- Floor: largest element <= x
- Ceil: smallest element >= x

If not found, return -1 for that value.

Example:
Input: arr = {3,4,4,7,8,10}, x = 5
Output: Floor = 4, Ceil = 7
*/

import java.util.Arrays;

public class FloorAndCeil {

    // ---------------------------------------------------
    // Brute Force Approach
    // Linear scan
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int[] bruteForce(int[] arr, int x) {

        int floor = -1;
        int ceil = -1;

        for (int num : arr) {

            if (num <= x) {
                floor = num; // keep updating (last valid)
            }

            if (num >= x) {
                ceil = num;
                break; // first valid ceil
            }
        }

        return new int[]{floor, ceil};
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search (two passes)
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int[] optimalApproach(int[] arr, int x) {

        int floor = findFloor(arr, x);
        int ceil = findCeil(arr, x);

        return new int[]{floor, ceil};
    }


    // Find Floor (largest ≤ x)
    private static int findFloor(int[] arr, int x) {

        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];   // possible answer
                left = mid + 1;   // try bigger
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }


    // Find Ceil (smallest ≥ x)
    private static int findCeil(int[] arr, int x) {

        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                ans = arr[mid];   // possible answer
                right = mid - 1;  // try smaller
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 5;

        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr, x)));
        System.out.println("Optimal Approach: " + Arrays.toString(optimalApproach(arr, x)));
    }
}