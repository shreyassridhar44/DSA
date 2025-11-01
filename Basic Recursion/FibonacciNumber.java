//Fibonacci Number Calculation

import java.util.*;

public class FibonacciNumber {

    // Brute Force Approach (Recursive)
    // Time Complexity: O(2^n)
    // Space Complexity: O(n) due to recursion stack
    public static int fibBruteForce(int n) {
        if (n <= 1) return n;
        return fibBruteForce(n - 1) + fibBruteForce(n - 2);
    }

    // Optimal Approach (Iterative Dynamic Programming)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int fibOptimal(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Brute Force Result: " + fibBruteForce(n));
        System.out.println("Optimal Result: " + fibOptimal(n));
    }
}
