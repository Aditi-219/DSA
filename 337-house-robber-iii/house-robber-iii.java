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
    // public int profit(TreeNode root){
    //     if(root==null) return 0;
    //     int steal=0;
    //     int skip=0;
    //     steal+=root.val;
    //     if(root.left!=null){
    //         skip+=profit(root.left);
    //         if(root.left.left!=null) steal+=profit(root.left.left);
    //         if(root.left.right!=null) steal+=profit(root.left.right);
    //     }
            
    //     if(root.right!=null){
    //         skip+=profit(root.right);
    //         if(root.right.left!=null) steal+=profit(root.right.left);
    //         if(root.right.right!=null) steal+=profit(root.right.right);
    //     }

    //     int maxLoot=0;
    //     maxLoot=Math.max(steal,skip);
    //     return maxLoot;
        
    // }

    public int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }

        int [] left=helper(root.left);
        int [] right=helper(root.right);

        int rob=root.val+left[1]+right[1];
        int skip=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{rob,skip};
    }
    public int rob(TreeNode root) {
        // if(root==null) return 0;
        
        // return profit(root);

        int [] res=helper(root);
        return Math.max(res[0],res[1]);


    }
}