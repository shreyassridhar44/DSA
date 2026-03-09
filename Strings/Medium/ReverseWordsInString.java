package Strings.Medium;

/*
 * 151. Reverse Words in a String
 *
 * Given a string s, reverse the order of words.
 * Words are separated by spaces.
 * Output must have exactly one space between words
 * and no leading or trailing spaces.
 */

import java.util.*;

public class ReverseWordsInString {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Split the string and rebuild in reverse order
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseWordsBrute(String s) {

        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            result.append(words[i]);

            if (i != 0)
                result.append(" ");
        }

        return result.toString();
    }


    // ---------------- BETTER APPROACH ----------------
    // Use stack to reverse order of words
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseWordsBetter(String s) {

        String[] words = s.trim().split("\\s+");

        Stack<String> stack = new Stack<>();

        for (String word : words)
            stack.push(word);

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {

            result.append(stack.pop());

            if (!stack.isEmpty())
                result.append(" ");
        }

        return result.toString();
    }


    // ---------------- OPTIMAL APPROACH ----------------
    // Traverse from right and build words manually
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String reverseWordsOptimal(String s) {

        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            if (i < 0)
                break;

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ')
                i--;

            result.append(s.substring(i + 1, j + 1)).append(" ");
        }

        return result.toString().trim();
    }


    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();

        // Choose approach
        // String result = reverseWordsBrute(s);
        // String result = reverseWordsBetter(s);
        String result = reverseWordsOptimal(s);

        System.out.println("Reversed words string:");
        System.out.println(result);

        sc.close();
    }
}