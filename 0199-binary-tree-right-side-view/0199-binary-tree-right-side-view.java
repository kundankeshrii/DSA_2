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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>ans=new ArrayList<>();
        Map<Integer,Integer>mpp=new TreeMap<>();
        Queue<Pair>q=new LinkedList<>();
        if(root==null) return ans;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it=q.poll();
            TreeNode node=it.node;
            int level=it.level;
            mpp.put(level,node.val);
            if(node.left!=null){
                q.add(new Pair(node.left,level+1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,level+1));
            }
        }
        ans.addAll(mpp.values());
        return ans;
        
    }
}
class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node,int level){
        this.node=node;
        this.level=level;
    }
}

 