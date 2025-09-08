/*
Pattern Name: Binary Alternating Triangle

Input: N = 6

Result:
1
01
101
0101
10101
010101
*/

import java.util.Scanner;

public class pattern11
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                if ((i + j) % 2 == 0)
                {
                    System.out.print("1");
                }
                else
                {
                    System.out.print("0");
                }
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
