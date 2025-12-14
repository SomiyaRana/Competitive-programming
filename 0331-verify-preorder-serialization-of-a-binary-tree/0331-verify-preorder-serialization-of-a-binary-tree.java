class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1; // one slot for root

        for (String node : nodes) {
            if (slots == 0) return false; // no place to put this node

            if (node.equals("#")) {
                slots--;        // null consumes one slot
            } else {
                slots--;        // non-null consumes one slot
                slots += 2;     // creates two new slots
            }
        }
        return slots == 0;
    }
}
