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
    public ListNode reverseKGroup(ListNode head, int k) {
        TreeNode dummyHead=TreeNode(-1);
        TreeNode prev=dummyHead;
        TreeNode tail=head;
        for(int i=0;i<k-1;++i){
            tail=tail.next;
        }
        prev=head;
        head=tail.next;
        tail.next=null;
        reverse(head,tail);
        prev.next=head;
    }
    private void reverse(TreeNode head,TreeNode tail){
        TreeNode curr=head;TreeNode prev=null;TreeNode next=curr;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=tail;
        tail=next;
    }
}