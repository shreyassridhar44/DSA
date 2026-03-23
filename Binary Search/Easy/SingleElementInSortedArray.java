/*
Problem: Search Single Element in a Sorted Array

Given a sorted array where every element appears twice except one,
find that single element.

Example:
Input: arr = [1,1,2,2,3,3,4,5,5,6,6]
Output: 4
*/

public class SingleElementInSortedArray {

    // ---------------------------------------------------
    // Brute Force Approach 1
    // Compare neighbors
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce1(int[] arr) {

        int n = arr.length;

        if (n == 1) return arr[0];

        for (int i = 0; i < n; i++) {

            // first element
            if (i == 0) {
                if (arr[i] != arr[i + 1]) return arr[i];
            }
            // last element
            else if (i == n - 1) {
                if (arr[i] != arr[i - 1]) return arr[i];
            }
            // middle elements
            else {
                if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                    return arr[i];
                }
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Brute Force Approach 2
    // XOR Trick
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce2(int[] arr) {

        int ans = 0;

        for (int num : arr) {
            ans ^= num;
        }

        return ans;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] arr) {

        int n = arr.length;

        // edge cases
        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        int low = 1, high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // unique element found
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // pairing logic
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) ||
                (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {

                // correct pairing → go right
                low = mid + 1;
            } else {
                // broken pairing → go left
                high = mid - 1;
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,3,4,5,5,6,6};

        System.out.println("Brute Force 1: " + bruteForce1(arr));
        System.out.println("Brute Force 2 (XOR): " + bruteForce2(arr));
        System.out.println("Optimal Approach: " + optimalApproach(arr));
    }
}