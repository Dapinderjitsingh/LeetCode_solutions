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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;
        for(int i = 1; i < k; i++){
            curr=curr.next;
        }
        ListNode first = curr;
        curr=head;
                while(curr != null){
            length++;
            curr=curr.next;
        }
        int moves=length-k;
        curr=head;
        while(moves > 0){
            curr=curr.next;
            moves--;
        }
        int temp = curr.val;
        curr.val=first.val;
        first.val=temp;
        return head;
    }
}