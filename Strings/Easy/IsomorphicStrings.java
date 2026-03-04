/*
 * Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if characters in s can be replaced to get t.
 * No two characters in s can map to the same character in t.
 */

import java.util.*;

public class IsomorphicStrings {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Use two HashMaps to maintain character mappings
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean isIsomorphicBrute(String s, String t) {

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2)
                    return false;
            } else {
                mapST.put(c1, c2);
            }

            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1)
                    return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Use fixed-size arrays for ASCII characters
    // Time Complexity: O(n)
    // Space Complexity: O(1) (since ASCII = 256)
    public static boolean isIsomorphicOptimal(String s, String t) {

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS[c1] != mapT[c2])
                return false;

            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
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

        if (s.length() != t.length()) {
            System.out.println("Strings are not isomorphic (length mismatch).");
            return;
        }

        // Choose approach
        // boolean result = isIsomorphicBrute(s, t);
        boolean result = isIsomorphicOptimal(s, t);

        System.out.println("Are the strings isomorphic? " + result);

        sc.close();
    }
}
