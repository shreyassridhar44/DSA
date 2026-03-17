/*
Given a non-negative integer x, return the square root of x rounded down
to the nearest integer.

You must not use built-in exponent functions.

*/

public class SqrtX {

    // ---------------------------------------------------
    // Brute Force Approach
    // Check each integer until square exceeds x
    // Time Complexity: O(√x)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int bruteForce(int x) {

        int i = 0;

        while ((long)i * i <= x) {
            i++;
        }

        return i - 1;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search without multiplication overflow
    // Use division instead of mid*mid
    // Time Complexity: O(log x)
    // Space Complexity: O(1)
    // ---------------------------------------------------
    public static int optimalApproach(int x) {
        if(x<2)
            return x;
        long left=1;
        long right=x/2;
        while(left<=right){
            long mid=left+(right-left)/2;
            long square=mid*mid;
            if(square==x)
                return (int)mid;
            else if(square<x)
                left=mid+1;
            else
                right=mid-1;

        }
        return (int)right;
    }


    // ---------------------------------------------------
    // Main Method (Driver Code)
    // ---------------------------------------------------
    public static void main(String[] args) {

        int x = 8;

        System.out.println("Brute Force Result: " + bruteForce(x));
        System.out.println("Optimal Approach Result: " + optimalApproach(x));
    }
}
