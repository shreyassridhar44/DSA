/*
Pattern Name: Concentric Number Square Pattern

Input: N = 6

Result:
6 6 6 6 6 6 6 6 6 6 6
6 5 5 5 5 5 5 5 5 5 6
6 5 4 4 4 4 4 4 4 5 6
6 5 4 3 3 3 3 3 4 5 6
6 5 4 3 2 2 2 3 4 5 6
6 5 4 3 2 1 2 3 4 5 6
6 5 4 3 2 2 2 3 4 5 6
6 5 4 3 3 3 3 3 4 5 6
6 5 4 4 4 4 4 4 4 5 6
6 5 5 5 5 5 5 5 5 5 6
6 6 6 6 6 6 6 6 6 6 6
*/

import java.util.Scanner;

public class pattern22
{
    static void printPattern(int N)
    {
        int size = 2 * N - 1;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                int top = i;
                int left = j;
                int right = size - 1 - j;
                int bottom = size - 1 - i;
                int min = Math.min(Math.min(top, bottom), Math.min(left, right));
                System.out.print((N - min) + " ");
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
