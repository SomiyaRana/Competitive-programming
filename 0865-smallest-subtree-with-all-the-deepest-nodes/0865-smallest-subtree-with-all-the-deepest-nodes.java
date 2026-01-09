class Solution {

    class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(null, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else if (right.depth > left.depth) {
            return new Pair(right.node, right.depth + 1);
        } else {
            return new Pair(root, left.depth + 1);
        }
    }
}
