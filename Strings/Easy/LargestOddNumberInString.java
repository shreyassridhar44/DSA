/*
 * Largest Odd Number in String
 *
 * Given a numeric string s, return the largest odd number that
 * can be formed as a substring without leading zeros.
 */

import java.util.*;

public class LargestOddNumberInString {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Generate all substrings and check if odd
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    public static String largestOddBrute(String s) {

        String maxOdd = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String sub = s.substring(i, j);

                if (sub.charAt(0) != '0') {

                    char last = sub.charAt(sub.length() - 1);

                    if ((last - '0') % 2 == 1) {

                        if (sub.length() > maxOdd.length())
                            maxOdd = sub;
                    }
                }
            }
        }

        return maxOdd;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Scan from right and find first odd digit
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static String largestOddOptimal(String s) {
         int ind = -1;

        // Find the last odd digit in the string
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }

        // Return empty string if no odd digit was found
        if (ind == -1) return "";

        // Skip leading zeroes up to the odd digit
        i = 0;
        while (i <= ind && s.charAt(i) == '0') i++;

        // Return substring from first non-zero to odd digit
        return s.substring(i, ind + 1);
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numeric string: ");
        String s = sc.nextLine();

        // Choose approach
        // String result = largestOddBrute(s);
        String result = largestOddOptimal(s);

        System.out.println("Largest odd number substring: " + result);

        sc.close();
    }
}
