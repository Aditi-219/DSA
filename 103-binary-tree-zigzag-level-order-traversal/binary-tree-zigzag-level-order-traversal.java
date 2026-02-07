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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        traversal(res,root,0);
        return res;
    }
    void traversal(List<List<Integer>> res, TreeNode root, int level){
        if(root==null) return;
        if(res.size()==level) res.add(new ArrayList<>());
        if(level%2==0) res.get(level).add(root.val);
        else res.get(level).add(0,root.val);
        traversal(res, root.left, level+1);
        traversal(res, root.right,level+1);
    }
}