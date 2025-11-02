/*
Excel Sheet Column Number
Given a string columnTitle that represents the column title as appears in an Excel sheet,
return its corresponding column number.

For example:
A -> 1
B -> 2
...
Z -> 26
AA -> 27
AB -> 28
ZY -> 701
*/

import java.util.*;

public class ExcelColumnNumber {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Logic: Process string from right to left and sum (chValue * 26^pos) using Math.pow.
    // Time Complexity: O(n) where n = length of columnTitle (Math.pow is constant-time)
    // Space Complexity: O(1)
    // Note: Uses Math.pow (floating) and casts to int — works for given constraints but less idiomatic.
    public static int titleToNumberBrute(String columnTitle) {
        columnTitle = columnTitle.trim().toUpperCase();
        int n = columnTitle.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            char ch = columnTitle.charAt(n - 1 - i);
            int val = ch - 'A' + 1;
            // pow returns double; cast to int (safe within constraints)
            result += val * (int) Math.pow(26, i);
        }
        return result;
    }

    // ---------------- OPTIMAL APPROACH ----------------
    // Logic: Iterate left to right, multiply accumulated result by 26 and add current character's value.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int titleToNumberOptimal(String columnTitle) {
        columnTitle = columnTitle.trim().toUpperCase();
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int val = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + val;
        }
        return result;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter column title: ");
        String columnTitle = sc.nextLine();

        // You can use either function. Optimal is preferred.
        System.out.println("Brute Force Result: " + titleToNumberBrute(columnTitle));
        System.out.println("Optimal Result: " + titleToNumberOptimal(columnTitle));

        sc.close();
    }
}
