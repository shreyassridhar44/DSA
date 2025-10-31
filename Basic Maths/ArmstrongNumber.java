//Problem Statement: Given an integer N, return true it is an Armstrong number otherwise return false.

import static java.lang.Math.*;
import java.util.Scanner; 

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println(false); // Negative numbers are not Armstrong numbers
            return;
        }
        if (n >= 0 && n <= 9) {
            System.out.println(true);  // Single digit numbers are always Armstrong numbers
            return;
        }

        // BRUTE FORCE APPROACH : O(d) time, O(d) space 
        /*
        String s = Integer.toString(n);       // Convert number to string
        int digits = s.length();
        int sum = 0;
        for (int i = 0; i < digits; i++) {
            int d = s.charAt(i) - '0';        // Convert char to digit
            sum += (int) pow(d, digits);      // Raise to power
        }
        System.out.println("Result: " + (sum == n));
        */

        //  OPTIMAL APPROACH : O(d) time, O(1) space
        int temp = n;
        int digits = 0;

        // Step 1: Count digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        // Step 2: Calculate Armstrong sum
        int sum = 0;
        temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) pow(digit, digits);
            temp /= 10;
        }

        System.out.println("Result: " + (sum == n));
    
    }
}
