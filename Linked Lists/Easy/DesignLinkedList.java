// Problem: Design a Linked List (Doubly Linked List Implementation)

public class DesignLinkedList {

    // Node class for doubly linked list
    private class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public DesignLinkedList() {
        head = new Node(0);   // dummy head
        tail = new Node(0);   // dummy tail

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    // Time Complexity: O(n) → optimized by choosing shortest direction
    // Space Complexity: O(1)
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node curr;

        // Pick shorter traversal direction
        if (index < size / 2) {
            curr = head.next;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail.prev;
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }

        return curr.val;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void addAtHead(int val) {
        addBetween(head, head.next, val);
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void addAtTail(int val) {
        addBetween(tail.prev, tail, val);
    }

    // Time Complexity: O(n) → traverses from best side
    // Space Complexity: O(1)
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        Node prev, next;

        if (index < size / 2) {
            prev = head;
            for (int i = 0; i < index; i++) prev = prev.next;
            next = prev.next;
        } else {
            next = tail;
            for (int i = size; i > index; i--) next = next.prev;
            prev = next.prev;
        }

        addBetween(prev, next, val);
    }

    // Time Complexity: O(n) → traverses from nearest side
    // Space Complexity: O(1)
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        Node curr;

        if (index < size / 2) {
            curr = head.next;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail.prev;
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }

    // Helper method
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private void addBetween(Node prev, Node next, int val) {
        Node newNode = new Node(val);

        newNode.prev = prev;
        newNode.next = next;

        prev.next = newNode;
        next.prev = newNode;

        size++;
    }

    // OPTIONAL main method for local testing in VS Code
    public static void main(String[] args) {
        DesignLinkedList list = new DesignLinkedList();

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);  // list: 1 -> 2 -> 3

        System.out.println(list.get(1));  // Output: 2

        list.deleteAtIndex(1);   // list: 1 -> 3
        System.out.println(list.get(1));  // Output: 3
    }
}
