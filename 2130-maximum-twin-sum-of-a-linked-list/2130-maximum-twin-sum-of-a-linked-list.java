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
        ListNode temp=head;
        List<Integer>list=new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int max=0;
        int n=list.size();
        for(int i=0;i<=n/2-1;i++){
           max= Math.max(max,list.get(i)+list.get(n-i-1));
        }
        return max ;
    }
}