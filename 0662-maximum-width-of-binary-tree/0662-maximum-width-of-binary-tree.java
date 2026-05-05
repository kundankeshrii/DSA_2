/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode node,long index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            long minIdx=q.peek().index;// *
            long first=0,last=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode node=p.node;
                long index=p.index-minIdx;//*for maintenance
                if(i==0) first=index;
                if(i==size-1) last=index;
                if(node.left!=null){
                    q.add(new Pair(node.left,2*index));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,2*index+1));
                }
            }
            ans=Math.max(ans,(int)(last-first+1));
        }
        return ans;
    }
}