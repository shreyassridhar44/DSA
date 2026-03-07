/*
 * Longest Subarray With Zero Sum
 *
 * Given an array containing both positive and negative integers,
 * find the length of the longest subarray whose sum is equal to zero.
 */

import java.util.*;

public class LongestSubarrayWithZeroSum {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Check every possible subarray
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    public static int longestSubarrayBrute(int[] nums) {

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }


    // ---------------- BETTER APPROACH ----------------
    // Running sum inside second loop
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int longestSubarrayBetter(int[] nums) {

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += nums[j];

                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Prefix Sum + HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int longestSubarrayOptimal(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
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

        System.out.println("Enter " + n + " elements (positive or negative):");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Choose approach
        // int result = longestSubarrayBrute(nums);
        // int result = longestSubarrayBetter(nums);
        int result = longestSubarrayOptimal(nums);

        System.out.println("Length of longest subarray with sum 0: " + result);

        sc.close();
    }
}
