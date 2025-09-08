/*
Pattern Name: Star Triangle Pattern
Input: N = 5
    *
    * *
    * * *
    * * * *
    * * * * *
 */

import java.util.Scanner;

public class pattern2 
{
    static void printPattern(int N) 
    {
        for (int i = 1; i <= N; i++) 
        {      
            for (int j = 1; j <= i; j++)
            {  // loop for columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (N): ");
        int N = sc.nextInt();
        printPattern(N);

        sc.close();
    }
}
