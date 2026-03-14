/*
LeetCode 42: Trapping Rain Water

Problem:
Given n non-negative integers representing an elevation map where the width
of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
1 <= height.length <= 2 * 10^4
0 <= height[i] <= 10^5
*/

public class TrappingRainWater {

    // ------------------------------------------------
    // Brute Force Approach
    // For each element find leftMax and rightMax
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // ------------------------------------------------
    public static int bruteForce(int[] height) {

        int n = height.length;
        int water = 0;

        for (int i = 0; i < n; i++) {

            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            water += Math.min(leftMax, rightMax) - height[i];
        }

        return water;
    }


    // ------------------------------------------------
    // Better Approach
    // Precompute leftMax[] and rightMax[]
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------
    public static int betterApproach(int[] height) {

        int n = height.length;
        int water = 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }


    // ------------------------------------------------
    // Optimal Approach (Two Pointer)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------
    public static int optimalApproach(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left <= right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }


    // ------------------------------------------------
    // Main Method
    // ------------------------------------------------
    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("Brute Force Result: " + bruteForce(height));
        System.out.println("Better Approach Result: " + betterApproach(height));
        System.out.println("Optimal Approach Result: " + optimalApproach(height));
    }
}
