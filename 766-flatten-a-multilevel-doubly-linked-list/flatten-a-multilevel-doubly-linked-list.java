/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
        while(curr!=null){
            if(curr.child!=null){
                Node next=curr.next;
                Node child=curr.child;
                curr.next=child;
                curr.child.prev=curr;
                while(child.next!=null) child=child.next;
                if(next!= null) {
                    child.next = next;
                    next.prev = child;
                }
                curr.child=null;
            }
            curr=curr.next;

        }
        return head;
    }
}