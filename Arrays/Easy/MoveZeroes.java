// 283. Move Zeroes
// Move all 0's to the end of the array while maintaining the relative order
// of non-zero elements. Must be done in-place.

import java.util.*;

public class MoveZeroes {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void moveZeroesBrute(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                temp[index++] = num;
            }
        }

        while (index < n) {
            temp[index++] = 0;
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // ---------------- OPTIMAL APPROACH (In-place) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Idea: Two pointers - one for reading, one for writing.
    public static void moveZeroesOptimal(int[] nums) {
        int index = 0; // position to place next non-zero

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // Fill remaining positions with 0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] brute = nums.clone();
        moveZeroesBrute(brute);
        System.out.println("Brute Force Result: " + Arrays.toString(brute));

        int[] optimal = nums.clone();
        moveZeroesOptimal(optimal);
        System.out.println("Optimal Result: " + Arrays.toString(optimal));
    }
}
