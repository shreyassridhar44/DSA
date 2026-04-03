/*
LeetCode 1283: Find the Smallest Divisor Given a Threshold

Problem:
Find smallest divisor such that:
sum(ceil(nums[i] / divisor)) <= threshold

Pattern:
Binary Search on Answer
*/

public class SmallestDivisorGivenThreshold {

    // ---------------------------------------------------
    // Brute Force Approach
    // Try all divisors from 1 to max(nums)
    // Time Complexity: O(n * max(nums))
    // ---------------------------------------------------
    public static int bruteForce(int[] nums, int threshold) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int d = 1; d <= max; d++) {

            int sum = 0;

            for (int num : nums) {
                sum += (num + d - 1) / d;
            }

            if (sum <= threshold) {
                return d;
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search on Divisor
    // Time Complexity: O(n log max(nums))
    // ---------------------------------------------------
    public static int optimalApproach(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isValid(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1; // try smaller divisor
            } else {
                low = mid + 1;  // need larger divisor
            }
        }

        return ans;
    }


    // Helper function
    private static boolean isValid(int[] nums, int threshold, int divisor) {

        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // ceil
        }

        return sum <= threshold;
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println("Brute Force: " + bruteForce(nums, threshold));
        System.out.println("Optimal Approach: " + optimalApproach(nums, threshold));
    }
}