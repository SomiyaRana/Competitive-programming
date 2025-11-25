class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            if (!set.contains(head.val)) {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }

        tail.next = null; // important: avoid old links

        return dummy.next;
    }
}
