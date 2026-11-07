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
        if(head==null || head.next==null) return head;
        int k=2;
        ListNode temp=head,prevGroup=null,nextGroup=null;
        while(temp!=null){
            ListNode KthNode=findKthNode(temp,k);
            if(KthNode==null){
                if(prevGroup!=null){
                    prevGroup.next=temp;
                    break;
                }

            }
            nextGroup=KthNode.next;
            KthNode.next=null;
            reverseLL(temp);
            if(head==temp){
                head=KthNode;
            }else{
                prevGroup.next=KthNode;
            }

            prevGroup=temp;
            temp=nextGroup;
        }
        return head;
    }
    private ListNode reverseLL(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    private ListNode findKthNode(ListNode temp,int k){
        k=k-1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
}