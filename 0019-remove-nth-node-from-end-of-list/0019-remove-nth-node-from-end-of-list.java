class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Create a gap of n + 1
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both together
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is before the node to remove
        slow.next = slow.next.next;

        return dummy.next;
    }
}