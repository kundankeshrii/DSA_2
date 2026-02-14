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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return fun(root,targetSum,0);

    }
    private boolean fun(TreeNode root, int targetSum,int currSum){
        if(root==null) return false;
        currSum+=root.val;
         if(root.left==null && root.right==null){
            return currSum==targetSum;
         }
        return 
        fun(root.left,targetSum,currSum)||
        fun(root.right,targetSum,currSum);
         
    }
}