/*
 * Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps.
 * Must try in-place solution with O(1) extra space.
 */

import java.util.*;

public class RotateArray {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Time Complexity: O(n * k)
    // Space Complexity: O(1)
    public static void rotateBrute(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            int last = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    // ---------------- OPTIMAL APPROACH (Reversal Algorithm) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void rotateOptimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array size must be greater than 0.");
            return;
        }

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter value of k (number of rotations): ");
        int k = sc.nextInt();

        // Choose approach here
        // rotateBrute(nums, k);
        rotateOptimal(nums, k);

        System.out.println("Array after rotation:");
        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}
