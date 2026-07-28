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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        int minnode = count / k;
        int remain = count % k ;
        ListNode[] ans = new ListNode[k];
        curr = head;
        for(int i = 0; i < k; i++){
            ans[i] = curr;
            int partsize = minnode;
            if(i < remain){
                partsize = minnode + 1;
            }
            for(int j = 1; j < partsize; j++){
                curr = curr.next;
                
            }
            if(curr != null){
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
            }
        }
        return ans;
    }
}