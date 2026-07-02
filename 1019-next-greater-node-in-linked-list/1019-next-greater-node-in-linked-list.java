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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer>list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int n=list.size();
        int[] arr=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && list.get(i)>=st.peek()){
                st.pop();
            }
            arr[i]= !st.isEmpty()? st.peek():0;
            st.add(list.get(i));
        }
        return arr;
    }
}