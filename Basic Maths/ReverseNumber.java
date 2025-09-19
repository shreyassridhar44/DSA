//Problem Statement: Given an integer N return the reverse of the given number.
import java.util.Scanner;

public class ReverseNumber {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow/underflow before multiplying/adding
            //Integer.MIN_VALUE = -2,147,483,648, Integer.MAX_VALUE = 2,147,483,647

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
            x /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = sc.nextInt();

        ReverseNumber sol = new ReverseNumber();
        int result = sol.reverse(x);
        System.out.println("Reversed number: " + result);

        sc.close();
    }
}
