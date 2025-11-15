// 35. Search Insert Position
// Binary search to find index of target, or insertion index if not found.

import java.util.*;

public class SearchInsertPosition {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            else if (nums[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }

        // If not found → left is the correct insertion index
        return left;
    }


    // MAIN (Input handling)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int target = sc.nextInt();

        System.out.println(searchInsert(nums, target));
    }
}
