// 152. Maximum Product Subarray
// Find a contiguous subarray with the largest product.

import java.util.*;

public class MaximumProductSubarray {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Try every subarray and calculate product.
    public static int maxProductBrute(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    // ---------------- OPTIMAL APPROACH (O(n)) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Track both max and min product at each step.
    public static int maxProductOptimal(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            if (current < 0) {
                // swap max and min if current number is negative
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);

            result = Math.max(result, maxProd);
        }

        return result;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.println("Brute Force Result: " + maxProductBrute(nums.clone()));
        System.out.println("Optimal Result: " + maxProductOptimal(nums.clone()));
    }
}
