/*
LeetCode 344: Reverse String

Problem:
Reverse the given character array in-place with O(1) extra space.

Example:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
*/

import java.util.Arrays;

public class ReverseString {

    // ---------------------------------------------------
    // Brute Force Approach
    // Use extra array
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ---------------------------------------------------
    public static void bruteForce(char[] s) {

        char[] temp = new char[s.length];

        for (int i = 0; i < s.length; i++) {
            temp[i] = s[s.length - 1 - i];
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = temp[i];
        }
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Two Pointer Technique (In-place)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static void optimalApproach(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            // swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        bruteForce(s);
        System.out.println("Brute Force: " + Arrays.toString(s));

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};

        optimalApproach(s2);
        System.out.println("Optimal Approach: " + Arrays.toString(s2));
    }
}