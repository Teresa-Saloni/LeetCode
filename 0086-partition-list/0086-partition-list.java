class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {

            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }

            head = head.next;
        }

        // Important: terminate large list
        large.next = null;

        // Connect both lists
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}