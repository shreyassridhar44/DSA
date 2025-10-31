// Happy Number Problem

import java.util.*;

public class HappyNumber {

    // Helper function to get sum of squares of digits
    public static int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // ---------------- BRUTE FORCE ----------------
    // Uses HashSet to detect cycles
    // Time Complexity: O(log n)
    // Space Complexity: O(log n)
    public static boolean isHappyBruteForce(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSquareSum(n);
        }
        return n == 1;
    }

    // ---------------- OPTIMAL ----------------
    // Uses Floyd's Cycle Detection (Tortoise & Hare)
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static boolean isHappyOptimal(int n) {
        int slow = n;
        int fast = getSquareSum(n); // fast starts one step ahead

        while (fast != 1 && slow != fast) {
            slow = getSquareSum(slow);
            fast = getSquareSum(getSquareSum(fast));
        }

        return fast == 1;
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Uncomment brute force if needed
        System.out.println("\n--- Brute Force Approach ---");
        System.out.println("Is Happy Number: " + isHappyBruteForce(n));

        System.out.println("\n--- Optimal Approach ---");
        System.out.println("Is Happy Number: " + isHappyOptimal(n));

        sc.close();
    }
}
