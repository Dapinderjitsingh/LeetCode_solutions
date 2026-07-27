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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1head = l1;
        Stack<Integer> st = new Stack<>();
        while(l1head != null){
            st.push(l1head.val);
            l1head = l1head.next;
        }
        ListNode l2head = l2;
        Stack<Integer> st1 = new Stack<>();
        while(l2head != null){
            st1.push(l2head.val);
            l2head = l2head.next;
        }
        int carry = 0;
        int digit = 0;
        ListNode head = null;
        while (!st.isEmpty() || !st1.isEmpty() || carry != 0){
            int x = 0;
            if(!st.isEmpty()) x = st.pop();
            int y = 0;
            if(!st1.isEmpty()) y = st1.pop();
            int sum = x + y +carry;
            carry = sum / 10;
            digit = sum % 10;
            ListNode newNode = new ListNode(digit);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}