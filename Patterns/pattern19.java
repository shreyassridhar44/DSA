/*
Pattern Name: Hollow Butterfly Star Pattern

Input: N = 6

Result:
************
*****  *****
****    ****
***      ***
**        **
*          *
*          *
**        **
***      ***
****    ****
*****  *****
************
*/

import java.util.Scanner;

public class pattern19
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N - i + 1; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * (i - 1); j++)
                System.out.print(" ");
            for (int j = 1; j <= N - i + 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * (N - i); j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
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
