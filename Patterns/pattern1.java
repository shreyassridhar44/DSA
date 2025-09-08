/* Pattern Name: Star Square Pattern
    Input: N = 5
    Pattern:
    *****
    *****
    *****
    *****
    *****
 */

 import java.util.Scanner;
 public class pattern1
 {
    static void printPattern(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows (N):");
        int n=sc.nextInt();
        printPattern(n);
        sc.close();
    }
 }