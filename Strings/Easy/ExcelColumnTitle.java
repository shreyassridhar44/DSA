/*
Excel Sheet Column Title
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:
1 -> A
2 -> B
...
26 -> Z
27 -> AA
28 -> AB
701 -> ZY
*/

import java.util.*;

public class ExcelColumnTitle {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Logic: Keep dividing the number by 26, adjust by -1 to make it 1-indexed (A=1, Z=26),
    // and keep taking modulo 26 to get letters from the end.
    // Build string in reverse order and reverse it at the end.
    // Time Complexity: O(log₍26₎(n))
    // Space Complexity: O(1)
    public static String convertToTitleBrute(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based indexing
            int remainder = columnNumber % 26;
            sb.append((char) ('A' + remainder));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    // ---------------- OPTIMAL APPROACH ----------------
    // Logic: Same as brute force but uses StringBuilder.insert(0, ch) to avoid reversing at the end.
    // Time Complexity: O(log₍26₎(n))
    // Space Complexity: O(1)
    public static String convertToTitleOptimal(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char ch = (char) ('A' + (columnNumber % 26));
            result.insert(0, ch);
            columnNumber /= 26;
        }
        return result.toString();
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter column number: ");
        int columnNumber = sc.nextInt();

        System.out.println("Brute Force Result: " + convertToTitleBrute(columnNumber));
        System.out.println("Optimal Result: " + convertToTitleOptimal(columnNumber));

        sc.close();
    }
}
