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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode present = current.left;
                while (present.right != null) {
                    present = present.right;
                }
                TreeNode orgright = current.right;
                present.right = orgright;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}