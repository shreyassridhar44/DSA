//Problem Statement: Given two integers N1 and N2, find their greatest common divisor.
import java.util.Scanner;

public class GCDofTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        // Brute Force Approach : O(min(n1, n2)) time, O(1) space
        /*
        int gcd = 1;
        int smaller = Math.min(n1, n2);
        for (int i = 1; i <= smaller; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println("GCD : " + gcd);
        */

        // Better Approach : O(min(n1, n2)) time, O(1) space
        /*
        int gcd = 1;
        int smaller = Math.min(n1, n2);
        for (int i = smaller; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
                break; // First common divisor from top will be the GCD
            }
        }
        System.out.println("GCD : " + gcd);
        */

        // Optimal Approach (Euclidean Algorithm) : O(log(min(n1, n2))) time, O(1) space
        int a = n1, b = n2;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("GCD : " + a);
    }
}
