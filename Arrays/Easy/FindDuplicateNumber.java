// 287. Find the Duplicate Number
// Given an array of integers nums containing n + 1 integers where each integer
// is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this duplicate number.
//
// You must solve the problem without modifying the array and using only O(1) extra space.
//
// Example:
// Input: nums = [1,3,4,2,2]
// Output: 2

// Only one duplicate number exists, but it can appear more than once.

import java.util.*;

public class FindDuplicateNumber {

    // Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Logic: Compare every pair of numbers to find a duplicate.
    public static int findDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }
        return -1; // Should never reach here if input is valid
    }

    // Optimal Approach — Floyd’s Cycle Detection (Tortoise & Hare)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Logic:
    // Treat array as a linked list where index is node and nums[i] is the next pointer.
    // Since one number repeats, a cycle must exist.
    // Step 1: Move slow by 1 step, fast by 2 steps until they meet.
    // Step 2: Move slow to start, then move both one step at a time until they meet again — that point is the duplicate number.
    public static int findDuplicateOptimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance (duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    // Alternate Optimal Approach — Using Binary Search on Count
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    // Logic:
    // For a given mid, count how many numbers <= mid.
    // If count > mid, the duplicate is in [1..mid], else [mid+1..n].
    public static int findDuplicateBinarySearch(int[] nums) {
        int low = 1, high = nums.length - 1;
        int duplicate = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                duplicate = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return duplicate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of elements in array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Brute Force Result: " + findDuplicateBruteForce(nums));
        System.out.println("Optimal (Floyd’s Cycle Detection) Result: " + findDuplicateOptimal(nums));
        System.out.println("Alternate Optimal (Binary Search) Result: " + findDuplicateBinarySearch(nums));
    }
}
