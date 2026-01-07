class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = treeSum(root);

        computeProduct(root);

        return (int)(maxProduct % MOD);
    }

    private long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    private long computeProduct(TreeNode node) {
        if (node == null) return 0;

        long left = computeProduct(node.left);
        long right = computeProduct(node.right);

        long subTreeSum = node.val + left + right;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
