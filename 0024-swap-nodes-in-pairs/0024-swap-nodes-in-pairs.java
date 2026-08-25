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
    public ListNode swapPairs(ListNode head) {
        int k=2;
        if(head==null || head.next==null) return head;
        ListNode temp=head;ListNode prevNode=null;ListNode nextNode;
        while(temp!=null){
            ListNode kthNode=findKthNode(temp,k);
            if(kthNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                    break;
                }
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            reverseLL(temp);
            if(head==temp){
                head=kthNode;
            }else{
                prevNode.next=kthNode;

            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
    private ListNode findKthNode(ListNode temp,int k){
        k=k-1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    private ListNode reverseLL(ListNode head){
        ListNode curr=head;ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}