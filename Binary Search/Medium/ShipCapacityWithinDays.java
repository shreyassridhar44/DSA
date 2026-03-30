/*
LeetCode 1011: Capacity To Ship Packages Within D Days

Problem:
Find minimum ship capacity such that all packages can be shipped
within given days.

Pattern:
Binary Search on Answer
*/

public class ShipCapacityWithinDays {

    // ---------------------------------------------------
    // Brute Force Approach
    // Try all capacities from max → sum
    // Time Complexity: O(n * sum)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int[] weights, int days) {

        int max = 0, sum = 0;

        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        for (int cap = max; cap <= sum; cap++) {

            if (canShip(weights, days, cap)) {
                return cap;
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Optimal Approach (Binary Search on Answer)
    // Time Complexity: O(n log sum)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] weights, int days) {

        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w); // min capacity
            high += w;              // max capacity
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1; // try smaller capacity
            } else {
                low = mid + 1;  // need bigger capacity
            }
        }

        return ans;
    }


    // Helper function
    private static boolean canShip(int[] weights, int days, int capacity) {

        int currentLoad = 0;
        int requiredDays = 1;

        for (int w : weights) {

            if (currentLoad + w > capacity) {
                requiredDays++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }

        return requiredDays <= days;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println("Brute Force: " + bruteForce(weights, days));
        System.out.println("Optimal Approach: " + optimalApproach(weights, days));
    }
}