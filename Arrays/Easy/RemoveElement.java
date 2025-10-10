//Problem Statement: Remove Element from Array

import java.util.*;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter value to remove: ");
        int val = sc.nextInt();

        // Uncomment one approach at a time
        // int k = removeElementBrute(nums, val);
        int k = removeElementOptimal(nums, val);

        System.out.println("k = " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }

    /* 
     * 🧠 Brute Force Approach:
     * Create a new array for elements not equal to val.
     * Then copy them back to nums.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int removeElementBrute(int[] nums, int val) {
        int n = nums.length;
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                temp[j++] = nums[i];
            }
        }

        // Copy back to original array
        for (int i = 0; i < j; i++) {
            nums[i] = temp[i];
        }

        return j;
    }

    /* 
     * ⚡ Optimal Approach (Two-Pointer Technique):
     * - Use one pointer to iterate, another to track position of non-val elements.
     * - Replace in-place.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int removeElementOptimal(int[] nums, int val) {
        int k = 0; // index to place non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
