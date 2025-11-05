// 2089. Find Target Indices After Sorting Array
// You are given an integer array nums and a target element target.
// A target index is an index i such that nums[i] == target.
// Return a list of target indices after sorting nums in non-decreasing order.
//
// Example:
// Input: nums = [1,2,5,2,3], target = 2
// Output: [1, 2]

import java.util.*;

public class TargetIndices {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Time Complexity: O(n log n)
    // Space Complexity: O(1) or O(n) depending on sorting implementation
    public static List<Integer> targetIndicesBrute(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }

    // ---------------- OPTIMAL APPROACH ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static List<Integer> targetIndicesOptimal(int[] nums, int target) {
        int countLess = 0, countEqual = 0;

        for (int num : nums) {
            if (num < target) countLess++;
            if (num == target) countEqual++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < countEqual; i++) {
            result.add(countLess + i);
        }

        return result;
    }


    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int target = sc.nextInt();

        System.out.println("Brute Force Result: " + targetIndicesBrute(nums.clone(), target));
        System.out.println("Optimal Result: " + targetIndicesOptimal(nums.clone(), target));
    }
}
