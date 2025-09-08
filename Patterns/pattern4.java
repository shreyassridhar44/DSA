/*
Pattern Name: Repeated Number Triangle
Input: N = 6
Pattern:
1
2 2
3 3 3
4 4 4 4
5 5 5 5 5
6 6 6 6 6 6
*/

import java.util.Scanner;

public class pattern4
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (N): ");
        int N = sc.nextInt();
        printPattern(N);
        sc.close();
    }
}
