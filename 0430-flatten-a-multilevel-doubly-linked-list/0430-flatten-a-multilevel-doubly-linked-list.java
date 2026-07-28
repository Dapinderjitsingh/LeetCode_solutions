/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flatten(Node head) {
        if (head == null) return null;

        dfs(head);
        return head;
    }

    // Returns the tail of the flattened list
    private Node dfs(Node head) {

        Node curr = head;
        Node tail = head;

        while (curr != null) {

            Node next = curr.next;

            if (curr.child != null) {

                // Flatten child list
                Node childHead = curr.child;
                Node childTail = dfs(childHead);

                // Connect current node with child
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                // Connect child tail with saved next
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }

                // Update tail
                tail = childTail;

                // Continue from the tail of child
                curr = childTail;
            } else {
                tail = curr;
            }

            curr = curr.next;
        }

        return tail;
    }
}