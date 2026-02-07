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
        List<Integer> res=new ArrayList<>();
        traversal(res,root,0);
        return res;
    }
    void traversal(List<Integer> res, TreeNode root, int level){
        if(root==null) return;
        if(res.size()==level)res.add(root.val);
        traversal(res, root.right,level+1);
        traversal(res, root.left, level+1);
    }
}