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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode leftlist = merge(lists, left, mid);
        ListNode rightlist = merge(lists, mid + 1, right);
        return mergeTwolists(leftlist, rightlist);
    }
    private ListNode mergeTwolists(ListNode leftlist, ListNode rightlist){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode h1 = leftlist;
        ListNode h2 = rightlist;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                curr.next = h1;
                h1 = h1.next;
                curr = curr.next;
            }
            else{
                curr.next = h2;
                h2 = h2.next;
                curr = curr.next;
            }
        }
        if(h1 != null) curr.next = h1;
        else curr.next = h2;
        return dummy.next;
    }
}