// 560. Subarray Sum Equals K
// Given an integer array and k, return number of subarrays whose sum = k.

import java.util.*;

public class SubarraySumEqualsK {

    // ---------------- BRUTE FORCE ----------------
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int subarraySumBrute(int[] nums, int k) {
        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }

        return count;
    }

    // ---------------- OPTIMAL (PREFIX SUM + HASHMAP) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int subarraySumOptimal(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // prefix sum zero occurs once initially

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // check if (sum - k) seen before
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // add current sum to map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println("Brute Force Result: " + subarraySumBrute(nums.clone(), k));
        System.out.println("Optimal Result: " + subarraySumOptimal(nums.clone(), k));
    }
}
