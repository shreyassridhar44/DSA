/*
LeetCode 1482: Minimum Number of Days to Make m Bouquets

Pattern:
Binary Search on Answer
*/

public class MinimumDaysToMakeBouquets {

    // ---------------------------------------------------
    // Brute Force Approach
    // Try all days from min → max
    // Time Complexity: O(n * range)
    // ---------------------------------------------------
    public static int bruteForce(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if ((long)m * k > n) return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        for (int d = min; d <= max; d++) {
            if (canMake(bloomDay, m, k, d)) {
                return d;
            }
        }

        return -1;
    }


    // ---------------------------------------------------
    // Optimal Approach
    // Binary Search on Days
    // Time Complexity: O(n log range)
    // ---------------------------------------------------
    public static int optimalApproach(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if ((long)m * k > n) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1; // try smaller day
            } else {
                low = mid + 1;  // need more days
            }
        }

        return ans;
    }


    // Helper function
    private static boolean canMake(int[] bloomDay, int m, int k, int day) {

        int count = 0;
        int bouquets = 0;

        for(int bloom : bloomDay){
            if(bloom<=day){
                count++;
                if(count==k){
                    bouquets++;
                    count=0;
                }
            }
            else{
                count=0;
            }  
        }

        return bouquets >= m;
    }


    // ---------------------------------------------------
    // Main Method
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;

        System.out.println("Brute Force: " + bruteForce(bloomDay, m, k));
        System.out.println("Optimal: " + optimalApproach(bloomDay, m, k));
    }
}