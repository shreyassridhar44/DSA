/*
LeetCode 875: Koko Eating Bananas

Problem:
Find minimum eating speed k such that Koko can finish all bananas within h hours.

Key Idea:
Binary Search on Answer (k)
*/

public class KokoEatingBananas {

    // ---------------------------------------------------
    // Brute Force Approach
    // Try all possible k from 1 to max(pile)
    // Time Complexity: O(n * max(pile))
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int[] piles, int h) {

        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        for (int k = 1; k <= max; k++) {

            long hours = 0;

            for (int p : piles) {
                hours += (p + k - 1) / k;
            }

            if (hours <= h) {
                return k;
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Optimal Approach (Your Logic)
    // Binary Search on k
    // Time Complexity: O(n log max(pile))
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // find max pile
        for (int p : piles) {
            high = Math.max(high, p);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                ans = mid;
                high = mid - 1; // try smaller k
            } else {
                low = mid + 1; // need bigger k
            }
        }

        return ans;
    }


    // Helper function
    private static boolean canFinish(int[] piles, int h, int k) {

        long hours = 0;

        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil division
        }

        return hours <= h;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println("Brute Force: " + bruteForce(piles, h));
        System.out.println("Optimal Approach: " + optimalApproach(piles, h));
    }
}