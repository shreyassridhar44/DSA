// 160. Intersection of Two Linked Lists
// Given heads of two singly linked lists, return the node where they intersect,
// or null if they do not intersect.

// Brute Force Approach:
// Compare every node of listA with every node of listB to find the first common node.
// Time Complexity: O(m * n), where m and n are lengths of listA and listB.
// Space Complexity: O(1).

// Optimal Approach (Two Pointers):
// Use two pointers that traverse both lists. When one reaches the end, jump to the other list's head.
// If there is an intersection, they will meet at the intersecting node after at most m + n steps.
// Time Complexity: O(m + n)
// Space Complexity: O(1)

import java.util.*;

public class IntersectionOfTwoLinkedLists {

    // Definition for singly-linked list (use this for all LL problems).
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // ---------------- BRUTE FORCE APPROACH ----------------
    public static ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        for (ListNode a = headA; a != null; a = a.next) {
            for (ListNode b = headB; b != null; b = b.next) {
                if (a == b) { // compare node references, not values
                    return a;
                }
            }
        }
        return null;
    }

    // ---------------- OPTIMAL APPROACH (TWO POINTERS) ----------------
    public static ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // At most 2 passes through each list
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA; // either intersection node or null
    }

    // Helper: build a list from array (no intersection wiring here)
    private static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int x : arr) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: print list (for basic debugging)
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // MAIN: input format:
    // nA
    // nA integers for listA
    // nB
    // nB integers for listB
    // Note: This main builds two independent lists (no shared nodes).
    // To truly test intersection behavior, you'd have to manually link nodes.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nA = sc.nextInt();
        int[] arrA = new int[nA];
        for (int i = 0; i < nA; i++) {
            arrA[i] = sc.nextInt();
        }

        int nB = sc.nextInt();
        int[] arrB = new int[nB];
        for (int i = 0; i < nB; i++) {
            arrB[i] = sc.nextInt();
        }

        ListNode headA = buildList(arrA);
        ListNode headB = buildList(arrB);

        // Brute force result
        ListNode intersectBrute = getIntersectionNodeBrute(headA, headB);
        System.out.println("Brute Force Intersection Node Value: " +
                (intersectBrute == null ? "null" : intersectBrute.val));

        // Optimal result
        ListNode intersectOptimal = getIntersectionNodeOptimal(headA, headB);
        System.out.println("Optimal Intersection Node Value: " +
                (intersectOptimal == null ? "null" : intersectOptimal.val));
    }
}
