/*
 * 75. Sort Colors
 *
 * Given an array nums containing 0s, 1s, and 2s representing
 * red, white, and blue respectively, sort them in-place so that
 * all 0s come first, then 1s, then 2s.
 *
 * You cannot use built-in sort.
 */

import java.util.*;

public class SortColors {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Use any sorting algorithm like Bubble Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void sortColorsBrute(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }


    // ---------------- BETTER APPROACH ----------------
    // Count frequency of 0s, 1s, and 2s
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void sortColorsBetter(int[] nums) {

        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {

            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int index = 0;

        while (count0-- > 0) nums[index++] = 0;
        while (count1-- > 0) nums[index++] = 1;
        while (count2-- > 0) nums[index++] = 2;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Dutch National Flag Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void sortColorsOptimal(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements (0, 1, or 2):");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Choose approach
        // sortColorsBrute(nums);
        // sortColorsBetter(nums);
        sortColorsOptimal(nums);

        System.out.println("Sorted colors array:");
        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}
