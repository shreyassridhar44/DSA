/*
Problem: Find how many times the array has been rotated

Given a sorted array (distinct elements) rotated unknown times,
return the number of rotations.

Observation:
Rotation count = index of minimum element

Example:
Input: arr = [4,5,6,7,0,1,2]
Output: 4
*/

public class RotationCountInSortedArray {

    // ---------------------------------------------------
    // Brute Force Approach
    // Find minimum element by scanning entire array
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int[] arr) {

        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        return index;
    }


    // ---------------------------------------------------
    // Better Approach
    // Find the "break point" where order decreases
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int betterApproach(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // break point found
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }

        return 0; // array not rotated
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Better Approach: " + betterApproach(arr));
        System.out.println("Optimal Approach: " + optimalApproach(arr));
    }
}