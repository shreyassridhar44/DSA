// Problem: Reverse a Singly Linked List (Iterative + Recursive Solutions)

public class ReverseLinkedList {

    // Singly Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // ----------------------------------------------------
    // Iterative Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ----------------------------------------------------
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;  // temporarily store next
            curr.next = prev;               // reverse pointer
            prev = curr;                    // move prev forward
            curr = nextNode;                // move curr forward
        }

        return prev; // new head
    }

    // ----------------------------------------------------
    // Recursive Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n) due to call stack
    // ----------------------------------------------------
    public static ListNode reverseListRecursive(ListNode head) {
        // base case: empty or last node
        if (head == null || head.next == null)
            return head;

        // reverse remaining list
        ListNode newHead = reverseListRecursive(head.next);

        // fix the "next" pointers
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // Utility Method: Print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Utility Method: Convert array → linked list
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // ----------------------------------------------------
    // MAIN FOR TESTING IN VS CODE
    // ----------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createList(arr);

        System.out.println("Original List:");
        printList(head);

        // Iterative reversal
        ListNode reversed1 = reverseListIterative(head);
        System.out.println("Reversed Iterative:");
        printList(reversed1);

        // To test recursive, rebuild the list
        head = createList(arr);

        // Recursive reversal
        ListNode reversed2 = reverseListRecursive(head);
        System.out.println("Reversed Recursive:");
        printList(reversed2);
    }
}
