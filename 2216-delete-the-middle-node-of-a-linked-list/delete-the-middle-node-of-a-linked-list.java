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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null ||head.next== null) return null;
        ListNode fast=head;
        ListNode demo=new ListNode(0);
        demo.next=head;
        while(fast!=null && fast.next!=null){
            demo=demo.next;
            fast=fast.next.next;
        }
        demo.next=demo.next.next;
        return head;
    }
}