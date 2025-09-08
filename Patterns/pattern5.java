/*
Pattern Name: Inverted Star Triangle
Input: N = 6
Pattern:
* * * * * *
* * * * *
* * * *
* * *
* *
*
*/

import java.util.Scanner;

public class pattern5
{
    static void printPattern(int N)
    {
        for (int i = N; i >= 1; i--)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print("* ");
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
