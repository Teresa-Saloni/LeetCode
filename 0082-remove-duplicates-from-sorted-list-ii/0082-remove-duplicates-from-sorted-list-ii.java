class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Found duplicates
            if (curr.next != null && curr.val == curr.next.val) {

                int duplicate = curr.val;

                // Skip ALL nodes having this value
                while (curr != null && curr.val == duplicate) {
                    curr = curr.next;
                }

                prev.next = curr;

            } else {
                // Current node is unique
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}