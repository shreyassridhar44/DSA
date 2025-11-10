// 1. Two Sum
// Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.

import java.util.*;

public class TwoSum {

    // ---------------- BRUTE FORCE ----------------
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Logic: Try every pair (i, j)
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0]; // theoretically never happens
    }

    // ---------------- OPTIMAL APPROACH ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Logic:
    // - Use HashMap to store (value → index)
    // - For each num, check if target - num exists in map
    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int target = sc.nextInt();

        System.out.println("Brute Force Result: " + Arrays.toString(twoSumBrute(nums.clone(), target)));
        System.out.println("Optimal Result: " + Arrays.toString(twoSumOptimal(nums.clone(), target)));
    }
}
