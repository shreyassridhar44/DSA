/*
LeetCode 1870: Minimum Speed to Arrive on Time

Problem:
Find minimum speed such that total travel time ≤ given hour.

Pattern:
Binary Search on Answer
*/

public class MinimumSpeedToArriveOnTime {

    // ---------------------------------------------------
    // Brute Force Approach
    // Try all speeds from 1 to 1e7
    // Time Complexity: O(n * 1e7) → not practical
    // ---------------------------------------------------
    public static int bruteForce(int[] dist, double hour) {

        for (int speed = 1; speed <= 10000000; speed++) {
            if (canReach(dist, hour, speed)) {
                return speed;
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search on Speed
    // Time Complexity: O(n log 1e7)
    // ---------------------------------------------------
    public static int optimalApproach(int[] dist, double hour) {

        int low = 1, high = 10000000;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(dist, hour, mid)) {
                ans = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1;  // need faster speed
            }
        }

        return ans;
    }


    // Helper function
    private static boolean canReach(int[] dist, double hour, int speed) {

        double time = 0.0;
        int n = dist.length;

        // all except last train
        for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }

        // last train
        time += (double) dist[n - 1] / speed;

        return time <= hour;
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] dist = {1, 3, 2};
        double hour = 2.7;

        System.out.println("Brute Force: " + bruteForce(dist, hour));
        System.out.println("Optimal Approach: " + optimalApproach(dist, hour));
    }
}