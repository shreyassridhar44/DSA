// Problem: Maximum Minimum Magnetic Force Between Balls

import java.util.*;

public class MagneticForceBetweenBalls {

    // Time Complexity: O(n log n + n log range)
    // Space Complexity: O(1)
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(position, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canPlace(int[] position, int m, int dist) {
        int placed = 1;
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= dist) {
                placed++;
                lastPos = position[i];
            }
            if (placed == m) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of baskets (n): ");
        int n = sc.nextInt();

        int[] position = new int[n];
        System.out.println("Enter the positions:");
        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }

        System.out.print("Enter number of balls (m): ");
        int m = sc.nextInt();

        int result = maxDistance(position, m);
        System.out.println("Maximum minimum magnetic force: " + result);

        sc.close();
    }
}
