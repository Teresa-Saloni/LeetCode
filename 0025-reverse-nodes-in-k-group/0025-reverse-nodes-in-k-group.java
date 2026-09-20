class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find kth node
            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Less than k nodes remaining
            if (kth == null)
                break;

            ListNode groupNext = kth.next;

            // Reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect reversed group
            ListNode oldStart = groupPrev.next;

            groupPrev.next = kth;
            groupPrev = oldStart;
        }

        return dummy.next;
    }
}