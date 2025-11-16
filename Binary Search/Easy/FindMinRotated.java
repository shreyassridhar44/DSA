// 153. Find Minimum in Rotated Sorted Array
// Return the minimum element in a rotated sorted array (distinct values).

import java.util.*;

public class FindMinRotated {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // If array is already sorted: smallest is at index 0
        if (nums[left] < nums[right])
            return nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Minimum is in the left half (including mid)
            else {
                right = mid;
            }
        }

        // left == right -> answer
        return nums[left];
    }

    // MAIN (Handles user input)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(findMin(nums));
    }
}
