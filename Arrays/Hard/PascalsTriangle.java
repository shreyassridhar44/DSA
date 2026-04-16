package Arrays.Hard;
/*
LeetCode 118: Pascal's Triangle

Problem:
Return first numRows of Pascal's Triangle
*/

import java.util.*;

public class PascalsTriangle {

    // ---------------------------------------------------
    // Brute Force Approach
    // Direct combination formula (nCr)
    // Time Complexity: O(n^3)
    // ---------------------------------------------------
    public static List<List<Integer>> bruteForce(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                row.add(nCr(i, j));
            }

            result.add(row);
        }

        return result;
    }

    private static int nCr(int n, int r) {

        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i) / (i + 1);
        }

        return (int) res;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Build using previous row
    // Time Complexity: O(n^2)
    // ---------------------------------------------------
    public static List<List<Integer>> optimalApproach(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int val = result.get(i - 1).get(j - 1) +
                              result.get(i - 1).get(j);
                    row.add(val);
                }
            }

            result.add(row);
        }

        return result;
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        int numRows = 5;

        System.out.println("Brute Force: " + bruteForce(numRows));
        System.out.println("Optimal: " + optimalApproach(numRows));
    }
}