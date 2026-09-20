class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // Find length and last node
        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // k may be greater than length
        k = k % len;

        if (k == 0)
            return head;

        // Make circular
        tail.next = head;

        // New tail is at position len-k
        ListNode newTail = head;

        for (int i = 1; i < len - k; i++) {
            newTail = newTail.next;
        }

        // New head is after newTail
        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }
}