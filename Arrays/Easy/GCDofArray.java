// Find Greatest Common Divisor of Array
// Given an integer array nums, return the greatest common divisor (GCD) of the smallest and largest number in nums.

import java.util.*;

public class GCDofArray {

    // Brute Force Approach
    // 1. Find min and max from the array.
    // 2. Iterate from 1 to min and check which number divides both.
    // Time Complexity: O(n + min(a,b))
    // Space Complexity: O(1)
    public static int gcdBruteForce(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // Optimal Approach using Euclid’s Algorithm
    // gcd(a, b) = gcd(b, a % b)
    // Time Complexity: O(n + log(min(a,b)))
    // Space Complexity: O(1)
    public static int gcdOptimal(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return findGCD(max, min);
    }

    // Helper function for Euclid’s Algorithm
    private static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Brute Force Result: " + gcdBruteForce(nums));
        System.out.println("Optimal Result: " + gcdOptimal(nums));

        sc.close();
    }
}
