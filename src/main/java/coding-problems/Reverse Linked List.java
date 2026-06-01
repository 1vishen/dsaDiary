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
    public ListNode reverseList(ListNode head) {
        /*
         * what we can do is use 3 ptr to keep track of curr 1 back and 1
         * forward, what we do is lest assume current is 1st element then our 1st
         * job is move 'after' from null to element next to current then we change
         * where ptr of current is pointing to point it to where 'before' is
         * pointing then we move 'before' to where current is then we move current
         * to where 'after' is then in next iteration 'after' will move to next
         * element
         */

        ListNode before = null;
        ListNode current = head;
        ListNode after = null;

        while (current != null) {
            // first assign next element to after ptr
            after = current.next;
            // then change ptr of current to point in reverse
            current.next = before;
            // then assign before ptr
            before = current;
            // move the current ptr forward
            current = after;
        }

        // at last when current == null then prev will be at last element
        return before;
    }
}
