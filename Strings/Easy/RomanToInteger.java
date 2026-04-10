/*
LeetCode 13: Roman to Integer

Problem:
Convert Roman numeral to integer
*/

import java.util.HashMap;

public class RomanToInteger {

    // ---------------------------------------------------
    // Brute Force Approach
    // Check pairs manually
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(String s) {

        int total = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = getValue(s.charAt(i));

            if (i + 1 < s.length() && curr < getValue(s.charAt(i + 1))) {
                total -= curr;
            } else {
                total += curr;
            }
        }

        return total;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Same logic but cleaner mapping
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = map.get(s.charAt(i));

            if (i + 1 < s.length() && curr < map.get(s.charAt(i + 1))) {
                total -= curr;
            } else {
                total += curr;
            }
        }

        return total;
    }


    // Helper function
    private static int getValue(char c) {

        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";

        System.out.println("Brute Force: " + bruteForce(s1));
        System.out.println("Optimal: " + optimalApproach(s1));

        System.out.println("Brute Force: " + bruteForce(s2));
        System.out.println("Optimal: " + optimalApproach(s2));

        System.out.println("Brute Force: " + bruteForce(s3));
        System.out.println("Optimal: " + optimalApproach(s3));
    }
}