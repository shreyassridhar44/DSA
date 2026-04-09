/*
LeetCode 8: String to Integer (atoi)

Problem:
Convert string to 32-bit signed integer with rules:
- Ignore leading spaces
- Handle sign
- Read digits
- Clamp within [-2^31, 2^31 - 1]
*/

public class StringToIntegerAtoi {

    // ---------------------------------------------------
    // Optimal Approach (Single pass parsing)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(String s) {

        int i = 0, n = s.length();

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle sign
        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // 3. Read digits
        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // 4. Check overflow BEFORE multiplying
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }


    // ---------------------------------------------------
    // Brute Force Approach
    // Use StringBuilder + parsing
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ---------------------------------------------------
    public static int bruteForce(String s) {

        s = s.trim();

        if (s.length() == 0) return 0;

        int sign = 1, i = 0;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-') sign = -1;
            i++;
        }

        StringBuilder num = new StringBuilder();

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num.append(s.charAt(i));
            i++;
        }

        if (num.length() == 0) return 0;

        try {
            return Integer.parseInt(num.toString()) * sign;
        } catch (Exception e) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        String s1 = "42";
        String s2 = "   -042";
        String s3 = "1337c0d3";
        String s4 = "0-1";
        String s5 = "words and 987";

        System.out.println("Optimal s1: " + optimalApproach(s1));
        System.out.println("Optimal s2: " + optimalApproach(s2));
        System.out.println("Optimal s3: " + optimalApproach(s3));
        System.out.println("Optimal s4: " + optimalApproach(s4));
        System.out.println("Optimal s5: " + optimalApproach(s5));
    }
}