//Problem Statement: Check if an array is sorted and rotated
import java.util.*;

public class CheckSortedAndRotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Uncomment one approach at a time
        // System.out.println("Brute Force: " + isSortedAndRotatedBrute(nums));
        System.out.println("Optimal: " + isSortedAndRotatedOptimal(nums));

        sc.close();
    }

    /* 
     * 🧠 Brute Force Approach:
     * Try all rotations and check if any rotation is sorted.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static boolean isSortedAndRotatedBrute(int[] nums) {
        int n = nums.length;

        for (int r = 0; r < n; r++) {
            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (nums[(i + r) % n] > nums[(i + r + 1) % n]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) return true;
        }

        return false;
    }

    /* 
     * ⚡ Optimal Approach:
     * Count how many times nums[i] > nums[i+1].
     * If this happens more than once, it's not a rotated sorted array.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isSortedAndRotatedOptimal(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // If there’s more than one "drop", it can’t be sorted and rotated
        return count <= 1;
    }
}
