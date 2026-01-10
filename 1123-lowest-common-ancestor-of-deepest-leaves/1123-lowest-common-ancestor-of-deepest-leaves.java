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
    int maxDepth=0;
    TreeNode ans=null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root,0);
        return ans;
    }
    private int helper(TreeNode root,int depth){
        if(root==null) return depth;
        int lD=helper(root.left,depth+1);
        int rD=helper(root.right,depth+1);
        if(lD>rD) {
            return lD;
        }
        if(rD>lD){
            return rD;
        }
        if(lD>=maxDepth){
            maxDepth=lD;
            ans=root;
        }
        return lD;
    }
}