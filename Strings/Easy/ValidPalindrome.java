/*
LeetCode 125: Valid Palindrome

Problem:
Check if a string is a palindrome after:
- removing non-alphanumeric characters
- converting to lowercase
*/

public class ValidPalindrome {

    // ---------------------------------------------------
    // Brute Force Approach
    // Clean string + reverse
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ---------------------------------------------------
    public static boolean bruteForce(String s) {

        StringBuilder cleaned = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String original = cleaned.toString();
        String reversed = cleaned.reverse().toString();

        return original.equals(reversed);
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Two pointers without extra space
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static boolean optimalApproach(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left)))
                left++;

            else if(!Character.isLetterOrDigit(s.charAt(right)))
                right--;

            else {
                if((Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))))
                    return false;

                left++;
                right--;
            }
        }

        return true;
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println("Brute Force (s1): " + bruteForce(s1));
        System.out.println("Optimal (s1): " + optimalApproach(s1));

        System.out.println("Brute Force (s2): " + bruteForce(s2));
        System.out.println("Optimal (s2): " + optimalApproach(s2));
    }
}