// 19. Remove Nth Node From End of List
// Given the head of a linked list, remove the nth node from the end of the list.
// Must solve in ONE PASS (two-pointer technique).

import java.util.*;

public class RemoveNthNode {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // ---------------- OPTIMAL APPROACH (ONE PASS) ----------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Technique: Two-pointer (fast and slow), maintaining a gap of n nodes.
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle removing head node
        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead to maintain gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast hits end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow is just before the node to delete
        slow.next = slow.next.next;

        return dummy.next;
    }

    // ---------------- HELPER: Build Linked List from input ----------------
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // ---------------- HELPER: Print Linked List ----------------
    public static void printList(ListNode head) {
        ListNode curr = head;
        List<String> out = new ArrayList<>();

        while (curr != null) {
            out.add(String.valueOf(curr.val));
            curr = curr.next;
        }

        System.out.println(out);
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();

        int n = sc.nextInt();

        ListNode head = buildList(arr);
        ListNode newHead = removeNthFromEnd(head, n);

        printList(newHead);
    }
}
