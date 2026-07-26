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
    public ListNode partition(ListNode head, int x) {
        ListNode greaterdummy = new ListNode(-1);
        ListNode lessdummy = new ListNode(-1);
        ListNode greatertail = greaterdummy;
        ListNode lesstail = lessdummy;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            if(curr.val < x){
                lesstail.next = curr;
                lesstail = curr;
            }
            else{
                greatertail.next = curr;
                greatertail = curr;
            }
            curr.next = null;
            curr = next;
        }
        // greatertail.next = null;
        lesstail.next = greaterdummy.next;
        return lessdummy.next;
    }
}