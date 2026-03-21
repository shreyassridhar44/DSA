/*
Problem: Implement Lower Bound

Given a sorted array arr[] and a value x,
find the smallest index such that arr[index] >= x.

If no such index exists, return n (size of array).

Example:
Input: arr = [1,2,4,4,5], x = 4
Output: 2
*/

import java.util.Arrays;

public class LowerBound {

    // ---------------------------------------------------
    // Brute Force Approach
    // Linear scan
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int[] arr, int x) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }

        return arr.length; // not found
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length; // default if not found

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                ans = mid;          // possible answer
                right = mid - 1;    // move left
            } else {
                left = mid + 1;     // move right
            }
        }

        return ans;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 4, 5};
        int x = 4;

        System.out.println("Brute Force: " + bruteForce(arr, x));
        System.out.println("Optimal Approach: " + optimalApproach(arr, x));
    }
}