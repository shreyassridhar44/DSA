/*
Pattern Name: Reverse Alphabet Triangle

Input: N = 6

Result:
F
E F
D E F
C D E F
B C D E F
A B C D E F
*/

import java.util.Scanner;

public class pattern18
{
    static void printPattern(int N)
    {
        for (int i = N; i >= 1; i--)
        {
            char ch = (char)('A' + i - 1);
            for (int j = i; j <= N; j++)
            {
                System.out.print(ch + " ");
                ch++;
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
