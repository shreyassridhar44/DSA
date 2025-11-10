// 121. Best Time to Buy and Sell Stock
// Given prices[i] representing stock price on the ith day,
// return the maximum profit achievable by buying and selling once.

import java.util.*;

public class BestTimeToBuySellStock {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Logic: Try every pair (buy, sell)
    public static int maxProfitBrute(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }

    // ---------------- OPTIMAL APPROACH (O(n)) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Idea:
    // Track minimum price so far.
    // At each day, compute potential profit = prices[i] - minPriceSoFar.
    // Keep updating maxProfit.
    public static int maxProfitOptimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("Brute Force Result: " + maxProfitBrute(prices.clone()));
        System.out.println("Optimal Result: " + maxProfitOptimal(prices.clone()));
    }
}
