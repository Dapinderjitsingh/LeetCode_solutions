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

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair current = q.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            // Get/create column
            TreeMap<Integer, PriorityQueue<Integer>> rows = map.get(col);

            if (rows == null) {
                rows = new TreeMap<>();
                map.put(col, rows);
            }

            // Get/create row
            PriorityQueue<Integer> values = rows.get(row);

            if (values == null) {
                values = new PriorityQueue<>();
                rows.put(row, values);
            }

            // Store value
            values.offer(node.val);

            // Left child
            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }

            // Right child
            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        // Build answer
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> current = new ArrayList<>();

            for (PriorityQueue<Integer> values : rows.values()) {

                while (!values.isEmpty()) {
                    current.add(values.poll());
                }
            }

            ans.add(current);
        }

        return ans;
    }
}