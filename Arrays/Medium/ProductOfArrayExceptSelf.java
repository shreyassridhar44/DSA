// 238. Product of Array Except Self
// Given nums[], return an array answer[] such that answer[i]
// = product of all elements except nums[i].
// Must run in O(n) and without division.

import java.util.*;

public class ProductOfArrayExceptSelf {

    // ---------------- BRUTE FORCE APPROACH ----------------
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Logic: For every element, multiply all others.
    public static int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) prod *= nums[j];
            }
            ans[i] = prod;
        }

        return ans;
    }

    // ---------------- OPTIMAL APPROACH (Prefix & Suffix) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Logic:
    // - prefix[i] = product of all elements to the left of i
    // - suffix[i] = product of all elements to the right of i
    // - answer[i] = prefix[i] * suffix[i]
    public static int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }

    // ---------------- OPTIMAL SPACE (Follow-up: O(1) extra space) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1) (output array not counted)
    // Logic:
    // - First pass: store prefix product directly in ans[]
    // - Second pass (backward): multiply by suffix product on the fly
    public static int[] productExceptSelfOptimalSpace(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Step 1: prefix pass
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: multiply suffix while traversing backward
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.println("Brute Force Result: " + Arrays.toString(productExceptSelfBrute(nums.clone())));
        System.out.println("Optimal (Prefix & Suffix): " + Arrays.toString(productExceptSelfOptimal(nums.clone())));
        System.out.println("Optimal Space (O(1)): " + Arrays.toString(productExceptSelfOptimalSpace(nums.clone())));
    }
}
