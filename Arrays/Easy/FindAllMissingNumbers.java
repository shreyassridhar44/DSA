// 448. Find All Numbers Disappeared in an Array
// Given an integer array nums of length n where all integers are in the range [1, n],
// some appear twice and others appear once. Return all the integers in the range [1, n]
// that do not appear in nums.
//
// Example:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]


import java.util.*;

public class FindAllMissingNumbers {

    // 🧠 Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Logic: For every number from 1 to n, check if it exists in nums.
    public static List<Integer> findDisappearedNumbersBruteForce(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) missing.add(i);
        }
        return missing;
    }

    // ⚡ Optimal Approach — Index Marking Trick (O(n) / O(1))
    // Logic:
    // 1️⃣ Iterate over nums.
    // 2️⃣ Use abs(nums[i]) as index → mark nums[index - 1] as negative.
    // 3️⃣ After marking, iterate again — indices that are *positive* correspond to missing numbers.
    //
    // Example:
    // nums = [4,3,2,7,8,2,3,1]
    // After marking → [-4,-3,-2,-7,8,2,-3,-1]
    // Indices with positive values: 4 (5th element), 5 (6th element) → [5,6]
    public static List<Integer> findDisappearedNumbersOptimal(int[] nums) {
        List<Integer> missing = new ArrayList<>();

        // Step 1: Mark seen numbers
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }

        // Step 2: Find missing (positive indices)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) missing.add(i + 1);
        }

        return missing;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Array size
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Brute Force Result: " + findDisappearedNumbersBruteForce(nums.clone()));
        System.out.println("Optimal (Index Marking) Result: " + findDisappearedNumbersOptimal(nums.clone()));
    }
}
