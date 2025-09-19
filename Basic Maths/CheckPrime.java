//Problem Statement: Given an integer N, check whether it is prime or not. A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.
import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        // Edge Case: numbers <= 1 are NOT prime
        if (n <= 1) {
            System.out.println(false);
            return;
        }

        //BRUTE FORCE APPROACH : O(n) time, O(1) space
        /*
        int divisors = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) divisors++;
        }
        System.out.println("Result: " + (divisors == 2));
        */

        // BETTER APPROACH : O(n) time, O(1) space
        /*
        boolean isPrime = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println("Result: " + isPrime);
        */

        //OPTIMAL APPROACH : O(sqrt(n)) time, O(1) space
        boolean isPrime = true;
        for (int i = 2; i * i <= n; i++) { // check only till sqrt(n)
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println("Result: " + isPrime);
    }
}
