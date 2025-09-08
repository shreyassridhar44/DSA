/*
Pattern Name: Alphabet Palindromic Pyramid

Input: N = 6

Result:
     A
    ABA
   ABCBA
  ABCDCBA
 ABCDEDCBA
ABCDEFEDCBA
*/

import java.util.Scanner;

public class pattern17
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N - i; j++)
            {
                System.out.print(" ");
            }
            char ch = 'A';
            for (int j = 1; j <= i; j++)
            {
                System.out.print(ch);
                ch++;
            }
            ch -= 2;
            for (int j = 1; j < i; j++)
            {
                System.out.print(ch);
                ch--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int N = sc.nextInt();
        printPattern(N);
        sc.close();
    }
}
