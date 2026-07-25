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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        ListNode curr = head;
        int length = 0;
        while(curr != null){
            length ++;
            curr = curr.next;
        }
        curr = head;
        int K = k % length;
        if(K == 0) return head;
        int toremove = length - K;
        while(toremove > 1){
            curr = curr.next;
            toremove--;
        }
        ListNode newhead = curr.next;
        curr.next = null;
        ListNode last = newhead;
        while(last.next != null){
            last = last.next;
        }
        last.next = head;
        head = newhead;
        return head;
    }
}