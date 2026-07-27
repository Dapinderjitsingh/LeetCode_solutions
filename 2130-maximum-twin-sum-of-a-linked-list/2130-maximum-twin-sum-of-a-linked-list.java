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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        ListNode revhead = prev;
        ListNode firsthead = head;
        int maxsum = 0;
        while(firsthead != null && revhead != null){
            int sum = firsthead.val + revhead.val;
            maxsum = Math.max(maxsum,sum);
            firsthead = firsthead.next;
            revhead = revhead.next;  
        } 
        return maxsum;
    }
}