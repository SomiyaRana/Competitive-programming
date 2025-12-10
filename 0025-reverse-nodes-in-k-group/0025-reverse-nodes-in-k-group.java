class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true) {
            ListNode check = curr;
            for (int i = 1; i < k && check != null; i++)
                check = check.next;
            if (check == null) break; 

            ListNode prev = null, next = null, start = curr;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevGroupEnd.next = prev; 
            start.next = curr;        
            prevGroupEnd = start;     
        }

        return dummy.next;
    }
}
