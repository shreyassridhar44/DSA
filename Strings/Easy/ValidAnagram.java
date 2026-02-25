/*
 * 242. Valid Anagram
 * Given two strings s and t,
 * return true if t is an anagram of s, otherwise false.
 */

import java.util.*;

public class ValidAnagram {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Sort both strings and compare
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static boolean isAnagramBrute(String s, String t) {

        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Use frequency count (since only lowercase letters)
    // Time Complexity: O(n)
    // Space Complexity: O(1)  (fixed size 26)
    public static boolean isAnagramOptimal(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        // Choose approach
        // boolean result = isAnagramBrute(s, t);
        boolean result = isAnagramOptimal(s, t);

        System.out.println("Is Anagram? " + result);

        sc.close();
    }
}