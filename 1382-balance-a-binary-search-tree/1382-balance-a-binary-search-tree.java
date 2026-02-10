import java.util.*;

class Solution {
    List<Integer> inorder = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return buildBalancedBST(0, inorder.size() - 1);
    }

    // Step 1: Inorder traversal
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    // Step 2: Build balanced BST
    private TreeNode buildBalancedBST(int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(inorder.get(mid));

        node.left = buildBalancedBST(start, mid - 1);
        node.right = buildBalancedBST(mid + 1, end);

        return node;
    }
}
