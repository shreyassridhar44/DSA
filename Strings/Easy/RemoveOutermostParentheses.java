/*
LeetCode 1021: Remove Outermost Parentheses

Problem:
Remove outermost parentheses from each primitive string
*/

public class RemoveOutermostParentheses {

    // ---------------------------------------------------
    // Brute Force Approach
    // Track primitives manually
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ---------------------------------------------------
    public static String bruteForce(String s) {

        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                if (depth > 0) result.append(c);
                depth++;
            } else {
                depth--;
                if (depth > 0) result.append(c);
            }
        }

        return result.toString();
    }


    // ---------------------------------------------------
    // Optimal Approach (Same but cleaner logic)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ---------------------------------------------------
    public static String optimalApproach(String s) {

        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                depth++;
                if (depth > 1) result.append(c);
            } else {
                if (depth > 1) result.append(c);
                depth--;
            }
        }

        return result.toString();
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";

        System.out.println("Brute Force: " + bruteForce(s1));
        System.out.println("Optimal: " + optimalApproach(s1));

        System.out.println("Optimal: " + optimalApproach(s2));
        System.out.println("Optimal: " + optimalApproach(s3));
    }
}