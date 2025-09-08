/*
Pattern Name: Alphabet Triangle

Input: N = 6

Result:
A
A B
A B C
A B C D
A B C D E
A B C D E F
*/

import java.util.Scanner;

public class pattern14
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
        {
            char ch = 'A';
            for (int j = 1; j <= i; j++)
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
