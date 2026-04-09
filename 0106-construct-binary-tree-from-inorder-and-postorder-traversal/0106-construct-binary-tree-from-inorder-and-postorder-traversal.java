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
    int postIndex=-1;
    HashMap<Integer,Integer>mpp=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        return buildTree(postorder,0,inorder.length-1);
    }

    //dhyan rakhne wali baat :- left-right-root hota hai postOrder me but 
    //aap piche se chal rahe ho toh root-right-left aayega 
    
    private TreeNode buildTree(int[] postorder,int inStart,int inEnd){
        if(inStart>inEnd) return null;
        int rootVal=postorder[postIndex--];
        TreeNode root=new TreeNode(rootVal);
        int inIndex=mpp.get(rootVal);
        root.right=buildTree(postorder,inIndex+1,inEnd);
        root.left=buildTree(postorder,inStart,inIndex-1);
        return root;
    }
}