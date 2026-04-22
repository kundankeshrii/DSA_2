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
        if(head==null) return null;
        ListNode beforeHead=new ListNode(-1);
        ListNode before=beforeHead;
        ListNode afterHead=new ListNode(-1);
        ListNode after=afterHead;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                before.next=temp;
                before=before.next;
            }else if(temp.val>=x){
                after.next=temp;
                after=after.next;
            }
            temp=temp.next;
        }
        //this will connect last element to null to avoid any cycle 
        after.next=null;
        before.next=afterHead.next;
        return beforeHead.next;
    }
}