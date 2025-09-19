//Problem Statement: Given an integer N, return true if it is a palindrome else return false.
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = sc.nextInt();

        // Brute Force Approach (String Conversion) : O(d) time, O(d) space
        /*
        String s = Integer.toString(x);
        int left = 0, right = s.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(isPalindrome);
        */

        // Optimal Approach (No String Conversion) : O(d) time, O(1) space
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            System.out.println(false); // Negative numbers or numbers ending in 0 (but not 0 itself) can't be palindrome
            return;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // x == reversedHalf (even number of digits)
        // OR x == reversedHalf / 10 (odd number of digits -> middle digit ignored)
        System.out.println(x == reversedHalf || x == reversedHalf / 10);
    }
}
