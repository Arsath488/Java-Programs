class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Skip all duplicate nodes
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // If duplicates were found
            if (prev.next != curr) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
