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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return countfromHere(root, targetSum)
        + pathSum(root.left, targetSum) 
        + pathSum(root.right, targetSum);
    }
    int countfromHere(TreeNode root, long targetSum){
        int count = 0;
        if(root == null) return 0;
        long remaining = targetSum - root.val;
        if(remaining == 0) count++;
        count += countfromHere(root.left, remaining);
        count += countfromHere(root.right, remaining);
        return count;
    }

}