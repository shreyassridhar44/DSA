/*
Pattern Name: Floyd's Triangle

Input: N = 6

Result:
1
2  3
4  5  6
7  8  9  10
11  12  13  14  15
16  17  18  19  20  21
*/

import java.util.Scanner;

public class pattern13
{
    static void printPattern(int N)
    {
        int num = 1;
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(num + "  ");
                num++;
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
