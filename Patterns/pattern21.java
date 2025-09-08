/*
Pattern Name: Hollow Square Star Pattern

Input: N = 6

Result:
******
*    *
*    *
*    *
*    *
******
*/

import java.util.Scanner;

public class pattern21
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                if (i == 1 || i == N || j == 1 || j == N)
                    System.out.print("*");
                else
                    System.out.print(" ");
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
