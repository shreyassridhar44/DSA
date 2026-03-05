/*
 * 485. Max Consecutive Ones
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */

import java.util.*;

public class MaxConsecutiveOnes {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Check every subarray and count consecutive 1s
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int maxConsecutiveOnesBrute(int[] nums) {

        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 1) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                } else {
                    break;
                }
            }
        }

        return maxCount;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Traverse array once and count consecutive 1s
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int maxConsecutiveOnesOptimal(int[] nums) {

        int maxCount = 0;
        int count = 0;

        for (int num : nums) {

            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements (0 or 1):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Choose approach
        // int result = maxConsecutiveOnesBrute(nums);
        int result = maxConsecutiveOnesOptimal(nums);

        System.out.println("Maximum consecutive 1s: " + result);

        sc.close();
    }
}
