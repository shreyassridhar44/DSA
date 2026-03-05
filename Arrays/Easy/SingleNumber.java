/*
 * 136. Single Number
 *
 * Given an integer array nums where every element appears twice except one,
 * find that single element.
 * The solution must run in O(n) time and O(1) extra space.
 */

import java.util.*;

public class SingleNumber {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // For every element count occurrences
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int singleNumberBrute(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {

                if (nums[i] == nums[j])
                    count++;
            }

            if (count == 1)
                return nums[i];
        }

        return -1;
    }


    // ---------------- BETTER APPROACH ----------------
    // Use HashMap to store frequencies
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int singleNumberBetter(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int num : nums)
            if (map.get(num) == 1)
                return num;

        return -1;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Use XOR property:
    // a ^ a = 0
    // a ^ 0 = a
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int singleNumberOptimal(int[] nums) {

        int result = 0;

        for (int num : nums)
            result ^= num;

        return result;
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
        // int result = singleNumberBrute(nums);
        // int result = singleNumberBetter(nums);
        int result = singleNumberOptimal(nums);

        System.out.println("Single number is: " + result);

        sc.close();
    }
}
