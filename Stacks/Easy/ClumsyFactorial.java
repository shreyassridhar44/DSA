// 1006. Clumsy Factorial
// We perform operations in a repeating order: * / + -
// Example: clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
// Division uses floor division, and normal arithmetic precedence applies.
// Return the clumsy factorial of n.
// Constraints: 1 <= n <= 10^4

import java.util.*;

public class ClumsyFactorial {

    // Brute Force Approach using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int clumsyBruteForce(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;
        int index = 0; // 0 -> '*', 1 -> '/', 2 -> '+', 3 -> '-'

        while (n > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * n);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / n);
            } else if (index % 4 == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }
            index++;
            n--;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    // Optimal Approach (Mathematical Pattern)
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // Observation:
    // For n = 1 → 1
    // For n = 2 → 2
    // For n = 3 → 6
    // For n = 4 → 7
    // For n >= 5:
    //   if n % 4 == 0 → n + 1
    //   if n % 4 == 1 → n + 2
    //   if n % 4 == 2 → n + 2
    //   if n % 4 == 3 → n - 1
    public static int clumsyOptimal(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;
        if (n == 4) return 7;

        if (n % 4 == 0) return n + 1;
        if (n % 4 == 1 || n % 4 == 2) return n + 2;
        return n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer n: ");
        int n = sc.nextInt();

        System.out.println("Brute Force Result: " + clumsyBruteForce(n));
        System.out.println("Optimal Result: " + clumsyOptimal(n));
        sc.close();
    }
}
