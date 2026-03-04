/*
 * 796. Rotate String
 *
 * A shift on string s moves the leftmost character to the rightmost position.
 * Return true if s can become goal after some number of shifts.
 */

import java.util.*;

public class RotateString {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Perform all possible rotations and compare with goal
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static boolean rotateStringBrute(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            if (rotated.equals(goal))
                return true;
        }

        return false;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // If goal is a rotation of s, it must appear inside s+s
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean rotateStringOptimal(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        String doubled = s + s;

        return doubled.contains(goal);
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter goal string: ");
        String goal = sc.nextLine();

        // Choose approach
        // boolean result = rotateStringBrute(s, goal);
        boolean result = rotateStringOptimal(s, goal);

        System.out.println("Can s become goal after rotations? " + result);

        sc.close();
    }
}
