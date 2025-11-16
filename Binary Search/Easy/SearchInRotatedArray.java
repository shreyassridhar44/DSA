// 33. Search in Rotated Sorted Array
// Return index of target in rotated sorted array or -1 if not found.

import java.util.*;

public class SearchInRotatedArray {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;

            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1; // target not found
    }

    // MAIN (Handles input)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int target = sc.nextInt();

        System.out.println(search(nums, target));
    }
}
