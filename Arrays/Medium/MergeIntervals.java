// 56. Merge Intervals
// Given a list of intervals, merge all overlapping intervals.

import java.util.*;

public class MergeIntervals {

    // ---------------- OPTIMAL APPROACH ----------------
    // Time Complexity: O(n log n) — sorting dominates.
    // Space Complexity: O(n) — to store merged intervals.
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Iterate and merge
        for (int[] interval : intervals) {
            // If result empty or no overlap → add new interval
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // Overlapping → merge with last interval
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int[][] ans = merge(intervals);

        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
