// 162. Find Peak Element
// Find any peak element using O(log n) binary search.

import java.util.*;

public class FindPeakElement {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If we are in an ascending slope, move right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            // Otherwise, peak is left (mid might be the peak)
            else {
                right = mid;
            }
        }

        return left; // OR right (both same)
    }

    // MAIN (Handles user input)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(findPeakElement(nums));
    }
}
