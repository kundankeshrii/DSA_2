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
    public int pairSum(ListNode head) {
        int cnt=0;
        ListNode temp=head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        if(cnt<=2){
            return head.val+head.next.val;
        }
        temp=head;
        for(int i=0;i<cnt/2-1;i++){
           temp=temp.next;
        }
        ListNode newHead=temp.next;
        temp.next=null;
        temp=newHead;
        ListNode prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        temp=head;
        int max=0;
        while(temp!=null && prev!=null){
            max=Math.max(max,temp.val+prev.val);
            temp=temp.next;
            prev=prev.next;
        }
        return max ;
    }
}