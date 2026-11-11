/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // //using HashMap
        // Map<ListNode,Integer>mpp=new HashMap<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     if (mpp.containsKey(temp)) return temp;
        //   mpp.put(temp,1);
        //   temp=temp.next;
        // }
        // return null;

        //Using Tortoise and Hare method :-
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
            return slow;
            }
        }
        return null;
    }
}