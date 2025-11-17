// 4. Median of Two Sorted Arrays
// Must run in O(log (m+n)) using binary search on partitions.

import java.util.*;

public class MedianOfTwoSortedArrays {

    // Time Complexity: O(log(min(m, n)))
    // Space Complexity: O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int totalLeft = (m + n + 1) / 2;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = totalLeft - i;

            int nums1LeftMax  = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums1RightMin = (i == m ? Integer.MAX_VALUE : nums1[i]);

            int nums2LeftMax  = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums2RightMin = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // Correct partition
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                } else {
                    return (Math.max(nums1LeftMax, nums2LeftMax) +
                            Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                }
            }
            else if (nums1LeftMax > nums2RightMin) {
                right = i - 1; // move left
            }
            else {
                left = i + 1; // move right
            }
        }

        return 0.0; // unreachable
    }

    // MAIN (for user input)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++)
            nums1[i] = sc.nextInt();

        int n = sc.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++)
            nums2[i] = sc.nextInt();

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
