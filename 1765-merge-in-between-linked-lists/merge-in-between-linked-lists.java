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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr=list1;
        for(int i=1;i<a;i++) curr=curr.next;
        ListNode h1=curr;
        for(int i=a;i<=b;i++) curr=curr.next;
        ListNode h2=curr.next;
        curr.next=null;
        h1.next=list2;
        ListNode curr2=list2;
        while(curr2.next!=null) curr2=curr2.next;
        curr2.next=h2;
        return list1;
    }
}