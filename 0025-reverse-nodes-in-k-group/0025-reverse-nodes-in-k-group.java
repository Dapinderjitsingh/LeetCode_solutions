/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupprev = dummy;
        while(true){
            ListNode curr = groupprev;
            int count = 0;
            while(count < k){
                curr = curr.next;
                if(curr == null) return dummy.next;
                count++;
            }

            ListNode groupNext = curr.next;
            ListNode groupStart = groupprev.next;
            ListNode prev = groupNext;
            ListNode current = groupStart;
            while( current != groupNext){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            groupprev.next = curr;
            groupprev = groupStart;
        }

        //return dummy.next;

    }
}