/*
 * 724. Find Pivot Index
 *
 * Given an integer array nums, return the pivot index.
 * The pivot index is where the sum of elements to the left
 * is equal to the sum of elements to the right.
 * Return the leftmost pivot index. If none exists, return -1.
 */

import java.util.*;

public class FindPivotIndex {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // For every index calculate left sum and right sum
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int pivotIndexBrute(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++)
                leftSum += nums[j];

            for (int j = i + 1; j < n; j++)
                rightSum += nums[j];

            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }


    // ---------------- BETTER APPROACH ----------------
    // Use prefix sum array
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int pivotIndexBetter(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        for (int i = 0; i < n; i++) {

            int leftSum = (i == 0) ? 0 : prefix[i - 1];
            int rightSum = prefix[n - 1] - prefix[i];

            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Use total sum and running left sum
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int pivotIndexOptimal(int[] nums) {

        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }

        return -1;
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // Choose approach
        // int result = pivotIndexBrute(nums);
        // int result = pivotIndexBetter(nums);
        int result = pivotIndexOptimal(nums);

        System.out.println("Pivot index: " + result);

        sc.close();
    }
}