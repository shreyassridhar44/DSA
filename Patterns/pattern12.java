/*
Pattern Name: Palindromic Number Pyramid

Input: N = 6

Result:
1          1
12        21
12       321
1234    4321
12345  54321
123456654321
*/

import java.util.Scanner;

public class pattern12
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j);
            }
            for (int j = 1; j <= 2 * (N - i); j++)
            {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--)
            {
                System.out.print(j);
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
