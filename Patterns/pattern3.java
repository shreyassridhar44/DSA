/* 
Pattern Name: Number Triangle
Input: N = 5
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
 */
import java.util.Scanner;

public class pattern3 
{
    static void printPattern(int N)
    {
        for (int i = 1; i <= N; i++)
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
        System.out.print("Enter the number of rows (N): ");
        int N = sc.nextInt();
        printPattern(N);
        sc.close();
    }
}
