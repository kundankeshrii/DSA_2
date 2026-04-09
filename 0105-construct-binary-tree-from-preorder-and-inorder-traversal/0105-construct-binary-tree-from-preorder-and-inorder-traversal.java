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
    int preIndex=0;
    HashMap<Integer,Integer>mpp=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
         return buildTree(preorder,0,inorder.length-1);
    }
    private TreeNode buildTree(int[] preorder,int inStart,int inEnd){
        if(inStart>inEnd) return null;
        int rootVal=preorder[preIndex++];
        TreeNode root=new TreeNode(rootVal);
        int inIndex=mpp.get(rootVal);
        root.left=buildTree(preorder,inStart,inIndex-1);
        root.right=buildTree(preorder,inIndex+1,inEnd);
        return root;

    }
}