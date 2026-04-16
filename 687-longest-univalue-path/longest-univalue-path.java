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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        int leftP=0,rightP=0;
        if(node.left!=null && node.val==node.left.val) leftP+=left+1;
        if(node.right!=null && node.val==node.right.val) rightP+=right+1;
        ans=Math.max(ans,leftP+rightP);
        return Math.max(leftP,rightP);
    }
}