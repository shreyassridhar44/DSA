// 81. Search in Rotated Sorted Array II
// Rotated sorted array WITH duplicates allowed.

import java.util.*;

public class SearchInRotatedArrayII {

    // Time Complexity: Worst case O(n), Average O(log n)
    // Space Complexity: O(1)
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return true;

            // Case 1: Duplicates at edges → shrink both sides
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Case 2: Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // Case 3: Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return false;
    }

    // MAIN (User input)
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
