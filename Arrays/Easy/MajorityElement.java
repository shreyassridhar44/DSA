/*
 * Majority Element
 *
 * Given an array nums, return the element that appears more than ⌊n/2⌋ times.
 * It is guaranteed that such an element exists.
 */

import java.util.*;

public class MajorityElement {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // For every element count occurrences
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int majorityElementBrute(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (nums[i] == nums[j])
                    count++;
            }

            if (count > n / 2)
                return nums[i];
        }

        return -1;
    }


    // ---------------- BETTER APPROACH ----------------
    // Use HashMap to store frequencies
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int majorityElementBetter(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int key : map.keySet())
            if (map.get(key) > nums.length / 2)
                return key;

        return -1;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Moore’s Voting Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int majorityElementOptimal(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate)
                count++;
            else
                count--;
        }

        return candidate;
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
        // int result = majorityElementBrute(nums);
        // int result = majorityElementBetter(nums);
        int result = majorityElementOptimal(nums);

        System.out.println("Majority element: " + result);

        sc.close();
    }
}