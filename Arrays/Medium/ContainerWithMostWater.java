// 11. Container With Most Water
// Given an array height[] where each element represents a vertical line,
// find two lines that together with the x-axis form the container holding max water.
// Return the maximum area.
//
// Optimal Approach: Two-Pointer Technique (O(n))
// Brute Force Approach: O(n^2) — commented out below.

import java.util.*;

public class ContainerWithMostWater {

    // ---------------- BRUTE FORCE APPROACH (O(n^2)) ----------------
    // Checks all possible pairs — too slow for n up to 1e5.
    // public static int maxAreaBrute(int[] height) {
    //     int maxArea = 0;
    //     for (int i = 0; i < height.length; i++) {
    //         for (int j = i + 1; j < height.length; j++) {
    //             int area = Math.min(height[i], height[j]) * (j - i);
    //             maxArea = Math.max(maxArea, area);
    //         }
    //     }
    //     return maxArea;
    // }

    // ---------------- OPTIMAL APPROACH (TWO POINTERS) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int maxAreaOptimal(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * width);

            // Move the pointer which has smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        System.out.println(maxAreaOptimal(height));
    }
}
