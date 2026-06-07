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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode>mpp=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int[] des:descriptions){
            int parent=des[0];
            int child=des[1];
            mpp.putIfAbsent(parent,new TreeNode(parent));
            mpp.putIfAbsent(child,new TreeNode(child));
            if(des[2]==1){
                 mpp.get(parent).left=mpp.get(child);
            }else{
                mpp.get(parent).right=mpp.get(child);
            }
            set.add(child);
        }
        for(int[] arr:descriptions){
            if(!set.contains(arr[0])){
                return mpp.get(arr[0]);
            }
        }
        return null;
    }
}