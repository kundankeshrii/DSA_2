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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        temp=head;
        if(cnt-n==0) return head=head.next;
        int currCnt=0;
        while(temp!=null && temp.next!=null){
            currCnt++;
            if(currCnt==cnt-n){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return head;
    }
}