/*
 * Longest Subarray With Given Sum K (Positives)
 *
 * Given an array nums and integer k, return the length of the longest
 * subarray whose sum equals k.
 *
 * NOTE: Optimal solution using sliding window works only for
 * arrays containing positive numbers (or non-negative numbers).
 */

import java.util.*;

public class LongestSubarrayWithSumKPositives {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Check every possible subarray
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    public static int longestSubarrayBrute(int[] nums, int k) {

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int sum = 0;

                for (int x = i; x <= j; x++) {
                    sum += nums[x];
                }

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }


    // ---------------- BETTER APPROACH ----------------
    // Calculate running sum inside second loop
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int longestSubarrayBetter(int[] nums, int k) {

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += nums[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }


    // ---------------- OPTIMAL APPROACH (SLIDING WINDOW) ----------------
    // Works only when array contains positive numbers
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int longestSubarrayOptimal(int[] nums, int k) {

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target sum k: ");
        int k = sc.nextInt();

        // Choose approach
        // int result = longestSubarrayBrute(nums, k);
        // int result = longestSubarrayBetter(nums, k);
        int result = longestSubarrayOptimal(nums, k);

        System.out.println("Length of longest subarray with sum " + k + " is: " + result);

        sc.close();
    }
}
