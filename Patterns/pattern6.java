/*
Pattern Name: Inverted Number Triangle
Input: N = 6
Pattern:
1 2 3 4 5 6
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
*/

import java.util.Scanner;

public class pattern6
{
    static void printPattern(int N)
    {
        for (int i = N; i >= 1; i--)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j + " ");
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
