//Problem Statement: Given an integer N, return the number of digits in N.
import java.util.Scanner;

public class CountDigits{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int N = sc.nextInt();

        // Handle negative numbers by taking absolute value
        int absN = Math.abs(N);

        // Brute Force Approach : O(d) where d is number of digits, O(1) space
        /*
        int count = 0;
        int temp = absN;
        if (temp == 0) count = 1; // handle case where N = 0
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        System.out.println("Number of digits : " + count);
        */

        // Optimal Approach : O(1) time, O(1) space
        int count;
        if (absN == 0) {
            count = 1; // log10(0) is undefined, so handle separately
        } else {
            count = (int)Math.log10(absN) + 1;
        }
        System.out.println("Number of digits : " + count);
        
        sc.close();
    }
}
