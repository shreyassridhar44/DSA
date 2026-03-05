/*
 * 14. Longest Common Prefix
 *
 * Given an array of strings, find the longest common prefix among them.
 * If there is no common prefix, return an empty string "".
 */

import java.util.*;

public class LongestCommonPrefix {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Compare characters one-by-one using the first string
    // Time Complexity: O(n * m)
    // n = number of strings
    // m = length of smallest string
    // Space Complexity: O(1)
    public static String longestCommonPrefixBrute(String[] strs) {

        if (strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Sort array, compare first and last string
    // Time Complexity: O(n log n + m)
    // Space Complexity: O(1)
    public static String longestCommonPrefixOptimal(String[] strs) {
        int n=strs.length;
        StringBuilder ans=new StringBuilder();
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[n-1];
        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            if(s1.charAt(i)!=s2.charAt(i))
                return ans.toString();
            ans.append(s1.charAt(i));
        }
        return ans.toString();
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] strs = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        // Choose approach
        // String result = longestCommonPrefixBrute(strs);
        String result = longestCommonPrefixOptimal(strs);

        System.out.println("Longest Common Prefix: " + result);

        sc.close();
    }
}
