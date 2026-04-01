import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;

        res.add(node.val);        // Root
        helper(node.left, res);   // Left
        helper(node.right, res);  // Right
    }
}