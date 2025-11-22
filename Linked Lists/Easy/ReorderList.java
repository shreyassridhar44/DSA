// 143. Reorder List
// Reorder a linked list: L0 → Ln → L1 → Ln-1 → ...
// You cannot modify node values; only rearrange nodes.

// Brute Force Approach:
// Time Complexity: O(n^2)
// Space Complexity: O(1)
//
// Optimal Approach (Find middle + Reverse second half + Merge):
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

public class ReorderList {

    // --------------------- ListNode Definition ---------------------
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // --------------------- BRUTE FORCE APPROACH ---------------------
    // For each node, find the last node and insert after current
    // Very slow (O(n^2)), but works.
    public static void reorderListBrute(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode curr = head;

        while (curr != null) {
            ListNode prev = curr;
            ListNode last = curr.next;

            // find last node
            while (last != null && last.next != null) {
                prev = last;
                last = last.next;
            }

            // if last == curr.next, nothing to reorder
            if (last == null || last == curr.next) break;

            // remove last from end
            prev.next = null;

            // insert after curr
            last.next = curr.next;
            curr.next = last;

            // move curr two steps
            curr = last.next;
        }
    }

    // --------------------- OPTIMAL APPROACH ---------------------
    // 1. Find middle of list
    // 2. Reverse second half
    // 3. Merge two halves alternating
    public static void reorderListOptimal(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find middle using slow-fast
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow is at mid
        ListNode second = slow.next;
        slow.next = null;

        // 2. Reverse second half
        second = reverse(second);

        // 3. Merge two halves
        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    // Reverse a linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    // --------------------- MAIN: INPUT HANDLING ---------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0) return;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int i = 0; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        ListNode head = dummy.next;

        // Uncomment to test brute force:
        // reorderListBrute(head);

        reorderListOptimal(head);

        // Print reordered list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
