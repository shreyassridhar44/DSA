/*
Problem: Aggressive Cows

Given stall positions and number of cows,
maximize the minimum distance between any two cows.

Pattern:
Binary Search on Answer
*/

import java.util.Arrays;

public class AggressiveCows {

    // ---------------------------------------------------
    // Brute Force Approach
    // Try all distances from 1 to max-min
    // Time Complexity: O(n * (max-min))
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int[] arr, int k) {

        Arrays.sort(arr);

        int maxDist = arr[arr.length - 1] - arr[0];

        for (int dist = 1; dist <= maxDist; dist++) {

            if (!canPlace(arr, k, dist)) {
                return dist - 1;
            }
        }

        return maxDist;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search on Distance
    // Time Complexity: O(n log(max-min))
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] arr, int k) {

        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlace(arr, k, mid)) {
                ans = mid;
                low = mid + 1; // try larger distance
            } else {
                high = mid - 1; // reduce distance
            }
        }

        return ans;
    }


    // Helper function
    private static boolean canPlace(int[] arr, int k, int minDist) {

        int count = 1; // place first cow
        int lastPos = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - lastPos >= minDist) {
                count++;
                lastPos = arr[i];
            }

            if (count >= k) return true;
        }

        return false;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {0, 3, 4, 7, 10, 9};
        int k = 4;

        System.out.println("Brute Force: " + bruteForce(arr, k));
        System.out.println("Optimal Approach: " + optimalApproach(arr, k));
    }
}