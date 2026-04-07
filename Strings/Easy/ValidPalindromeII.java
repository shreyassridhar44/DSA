/*
LeetCode 680: Valid Palindrome II

Problem:
Check if string can become palindrome after deleting at most one character.
*/

public class ValidPalindromeII {

    // ---------------------------------------------------
    // Brute Force Approach
    // Try removing each character and check palindrome
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    // ---------------------------------------------------
    public static boolean bruteForce(String s) {

        for (int i = 0; i < s.length(); i++) {

            String modified = s.substring(0, i) + s.substring(i + 1);

            if (isPalindrome(modified)) {
                return true;
            }
        }

        return isPalindrome(s);
    }

    private static boolean isPalindrome(String str) {

        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Two pointers with one deletion allowed
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static boolean optimalApproach(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                // try skipping either left or right
                return isPalindromeRange(s, left + 1, right) ||
                       isPalindromeRange(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindromeRange(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        String s1 = "abca";
        String s2 = "abc";

        System.out.println("Brute Force (s1): " + bruteForce(s1));
        System.out.println("Optimal (s1): " + optimalApproach(s1));

        System.out.println("Brute Force (s2): " + bruteForce(s2));
        System.out.println("Optimal (s2): " + optimalApproach(s2));
    }
}