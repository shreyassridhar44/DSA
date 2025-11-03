// 2520. Count Digits That Divide a Number
// Given an integer num, return the number of digits in num that divide num.
//
// Example:
// Input: num = 1248
// Output: 4
// Explanation: 1248 is divisible by all its digits (1, 2, 4, 8)


import java.util.*;

public class CountDigitsThatDivideNumber {

    // 🧠 Brute Force / Optimal — same in this case (O(log n))
    // Logic: extract each digit and check if it divides num
    public static int countDigits(int num) {
        int count = 0;
        int n = num; // Copy to preserve original num

        while (n > 0) {
            int digit = n % 10;
            if (num % digit == 0) {
                count++;
            }
            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int result = countDigits(num);
        System.out.println(result);
    }
}
