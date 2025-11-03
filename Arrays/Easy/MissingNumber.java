// 268. Missing Number
// Given an array containing n distinct numbers in the range [0, n],
// return the only number missing from the range.

import java.util.*;

public class MissingNumber {

    // Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Logic: For every number from 0 to n, check if it exists in the array.
    public static int missingNumberBruteForce(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }

    // Optimal Approach — Using Sum Formula
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Logic:
    // The sum of numbers from 0 to n = n*(n+1)/2
    // Subtract the sum of the array from this — the remainder is the missing number.
    public static int missingNumberOptimal(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    // Alternative Optimal — XOR Method
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Logic:
    // XOR all numbers from 0 to n and all numbers in the array.
    // Since XOR cancels out equal numbers, the remaining one is missing.
    public static int missingNumberXOR(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Brute Force Result: " + missingNumberBruteForce(nums));
        System.out.println("Optimal (Sum) Result: " + missingNumberOptimal(nums));
        System.out.println("Optimal (XOR) Result: " + missingNumberXOR(nums));
    }
}
