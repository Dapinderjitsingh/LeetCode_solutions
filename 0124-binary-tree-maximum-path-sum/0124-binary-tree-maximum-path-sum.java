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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    int helper(TreeNode root){
        if(root == null) return 0;
        int leftgain = helper(root.left);
        int rightgain = helper(root.right);
        leftgain = Math.max(0, leftgain);
        rightgain = Math.max(0, rightgain);
        int currpath = leftgain + root.val + rightgain;
        maxSum = Math.max(currpath, maxSum);
        return root.val + Math.max(leftgain, rightgain);
    }
}