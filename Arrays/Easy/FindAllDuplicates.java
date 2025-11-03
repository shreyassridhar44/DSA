// 442. Find All Duplicates in an Array
// Given an integer array nums of length n where all integers are in the range [1, n],
// each integer appears once or twice. Return an array of all the integers that appear twice.
//
// You must write an algorithm that runs in O(n) time and uses only constant extra space.
//
// Example:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]

// Each integer appears once or twice.

import java.util.*;

public class FindAllDuplicates {

    // Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Logic: Compare each element with all others.
    public static List<Integer> findDuplicatesBruteForce(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && !duplicates.contains(nums[i])) {
                    duplicates.add(nums[i]);
                }
            }
        }
        return duplicates;
    }

    // Optimal Approach — Index Marking
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //
    // Logic:
    // Each number in nums is between [1, n]. Use the number’s absolute value as an index.
    // When you see a number, flip the sign at that index.
    // If you encounter a number whose corresponding index is already negative, that number is a duplicate.
    //
    // Example:
    // nums = [4,3,2,7,8,2,3,1]
    // Step-by-step:
    // i=0 → |4| → index=3 → flip nums[3] → [4,3,2,-7,8,2,3,1]
    // i=1 → |3| → index=2 → flip nums[2] → [4,3,-2,-7,8,2,3,1]
    // i=2 → |2| → index=1 → flip nums[1] → [4,-3,-2,-7,8,2,3,1]
    // i=3 → |7| → index=6 → flip nums[6] → [4,-3,-2,-7,8,2,-3,1]
    // i=4 → |8| → index=7 → flip nums[7] → [4,-3,-2,-7,8,2,-3,-1]
    // i=5 → |2| → index=1 → nums[1] is already negative → duplicate = 2
    // i=6 → |3| → index=2 → nums[2] is already negative → duplicate = 3
    // Result: [2,3]
    public static List<Integer> findDuplicatesOptimal(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Brute Force Result: " + findDuplicatesBruteForce(nums.clone()));
        System.out.println("Optimal (Index Marking) Result: " + findDuplicatesOptimal(nums.clone()));
        sc.close();
    }
}
