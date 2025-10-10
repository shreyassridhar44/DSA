//Problem Statement: Remove Duplicates from Sorted Array
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Uncomment one approach at a time
        // int k = removeDuplicatesBrute(nums);
        int k = removeDuplicatesOptimal(nums);

        System.out.println("k = " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }

    /* 
     * 🧠 Brute Force Approach:
     * Use a HashSet to store unique elements.
     * Copy them back to the original array.
     * 
     * Time Complexity: O(n log n)  (because of sorting while converting back to array)
     * Space Complexity: O(n)
     */
    public static int removeDuplicatesBrute(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list); // maintain sorted order

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }

    /* 
     * ⚡ Optimal Approach (Two-Pointer Technique):
     * Since the array is sorted, duplicates will be adjacent.
     * Use pointer `i` to track unique positions.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int removeDuplicatesOptimal(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // pointer for unique elements

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1; // length of unique elements
    }
}
