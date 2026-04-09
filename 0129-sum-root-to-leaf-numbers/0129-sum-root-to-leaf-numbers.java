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
    List<String>ans=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public int sumNumbers(TreeNode root) {
        helper(root);
        int sum=0;
        for(int i=0;i<ans.size();i++){
            sum+=Integer.parseInt(ans.get(i));
        }
        return sum;
    }
    private void helper(TreeNode root){
        if(root==null) return;
        sb.append(root.val);
        if(root.left==null && root.right==null){
           ans.add(sb.toString());
        }else{
        helper(root.left);
        helper(root.right);
        }
        sb.deleteCharAt(sb.length()-1);

    }
}