//Problem Statement: Given an integer N, return all divisors of N.
import java.util.*;

public class PrintDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        // BRUTE FORCE APPROACH : O(n) time, O(d) space where d is number of divisors
        /*
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) { // check all numbers from 1 to n
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        System.out.println("Divisors : " + divisors);
        */

        // OPTIMAL APPROACH : O(sqrt(n)) time, O(d) space where d is number of divisors
        List<Integer> divisors = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>(); // to store larger divisors

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) { // avoid duplicate when i == n/i (perfect square)
                    secondHalf.add(n / i);
                }
            }
        }

        // Add the larger divisors in reverse order to maintain ascending order
        for (int i = secondHalf.size() - 1; i >= 0; i--) {
            divisors.add(secondHalf.get(i));
        }

        System.out.println("Divisors : " + divisors);
        sc.close();
    }
}
