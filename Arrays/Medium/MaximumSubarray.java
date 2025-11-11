// 53. Maximum Subarray
// Find the contiguous subarray with the largest sum.
// Example: nums = [-2,1,-3,4,-1,2,1,-5,4] → Output = 6

import java.util.*;

public class MaximumSubarray {

    // ---------------- BRUTE FORCE ----------------
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int maxSubArrayBrute(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    // ---------------- OPTIMAL APPROACH (Kadane’s Algorithm) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Logic:
    // - Keep a running sum (currentSum)
    // - If currentSum < 0, reset to 0 (start new subarray)
    // - Keep track of global max (maxSum)
    public static int maxSubArrayKadane(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) currentSum = 0; // reset if negative
        }

        return maxSum;
    }

    // ---------------- FOLLOW-UP: Divide & Conquer ----------------
    // Time Complexity: O(n log n)
    // Space Complexity: O(log n) due to recursion
    // Idea: split array into 3 parts:
    // 1. max subarray on left
    // 2. max subarray on right
    // 3. max subarray crossing the mid
    public static int maxSubArrayDivideConquer(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid + 1, right);
        int crossSum = crossSum(nums, left, mid, right);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private static int crossSum(int[] nums, int left, int mid, int right) {
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Brute Force Result: " + maxSubArrayBrute(nums.clone()));
        System.out.println("Kadane’s Algorithm Result: " + maxSubArrayKadane(nums.clone()));
        System.out.println("Divide & Conquer Result: " + maxSubArrayDivideConquer(nums.clone()));
    }
}
