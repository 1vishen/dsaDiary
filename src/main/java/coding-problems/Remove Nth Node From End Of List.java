/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * we use slow pointer & fast ptr as ruler we create a distance b/w them
         * of n then put fast ptr at end because n is measured from end
         */
        /*
         * we need to take into account if head is the one to remove in that case
         * since we need slow before the node to remove we can't start from head,
         * so we will use a dummy
         */

        /*
         * need to pass something to ListNode() constructor cause it needs a
         * parameter
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // now we move fast to n + 1, so we need have stop condt just 1 before
        int count = 0;
        while (count < n + 1 && fast != null) {
            fast = fast.next;
            count++;
        }

        /*
         * now that fast is at (n + 1)th node, we need to move slow and fast
         * together till fast is past the last node
         */
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        /* now slow is at (n - 1)th node */
        slow.next = slow.next.next;
        /*
         * if head was removed i.e. slow was at dummy itself and dummy.next has
         * the new head
         */
        return dummy.next;
    }
}
