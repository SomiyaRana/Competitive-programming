public class Codec {

    // Serialize BST using preorder traversal
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Deserialize BST from preorder traversal
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] vals = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String v : vals) {
            if (!v.isEmpty()) {
                queue.offer(Integer.parseInt(v));
            }
        }

        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<Integer> queue, int low, int high) {
        if (queue.isEmpty()) return null;

        int val = queue.peek();
        if (val < low || val > high) return null;

        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = build(queue, low, val);
        node.right = build(queue, val, high);

        return node;
    }
}
