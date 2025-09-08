/*
Pattern Name: Repeated Alphabet Triangle

Input: N = 6

Result:
A
B B
C C C
D D D D
E E E E E
F F F F F F
*/

import java.util.Scanner;

public class pattern16
{
    static void printPattern(int N)
    {
        char ch = 'A';
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(ch + " ");
            }
            System.out.println();
            ch++;
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
