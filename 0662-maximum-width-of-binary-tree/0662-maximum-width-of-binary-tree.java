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
    class pair{
        TreeNode node;
        long pos;
        pair(TreeNode node,long pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        if(root == null) return 0;
        int maxwidth = Integer.MIN_VALUE;
        q.offer(new pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            long first = q.peek().pos;
            long last = 0;
            for(int i = 0; i < size; i++){
                pair current = q.poll();
                TreeNode node = current.node;
                long pos = current.pos;
                last = pos;
                if(node.left != null){
                    q.offer(new pair(node.left, 2 * pos + 1));
                }
                if(node.right != null) q.offer(new pair(node.right, 2 * pos + 2));
            }
            long width = last - first + 1;
            maxwidth = (int) Math.max(width, maxwidth);
        }
        return maxwidth;
    }
}