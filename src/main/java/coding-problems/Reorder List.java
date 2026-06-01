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
    public void reorderList(ListNode head) {
        /*
         * we need to break list into 2 halves then reverse 2nd half then
         * merge 2nd half with 1st half with alternating notes from both
         */

        /*
         * to find length : we can use slow and fast pointers, slow moves 1 and
         * fast moves 2 so when fast is at end slow is at middle
         */

        ListNode slow = head;
        ListNode fast = head;

        /*
         * how to stop fast from moving 1 step more we use fast != null but that means
         * fast have moven past last element and if we do fast.next
         * != null then that means we have not included last element
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now slow is at mid point, now we reverse the 2nd half
        ListNode before = null;
        /*
         * in both even and odd we start from slow.next because in even first node
         * of 2nd half becomes last node and in case of odd last node fo 1st half
         * becomes last element
         */
        ListNode current = slow.next;
        ListNode after = null;

        /*
         * we need to know if list is even or odd in order to determine starting
         * point of 2nd half, if (fast != null and fast.next == null) that means list is
         * odd and fast is at last node and slow is at middle node so 2nd
         * half start from slow.next and if fast == null that means list is even slow is
         * at first node of 2nd half and 2nd half start from slow.next this
         * happens because in even the first node of 2nd half becomes last node of
         * the list anyways, so in both even and odd cases slow.next should be null
         */
        slow.next = null;

        while (current != null) {
            // move after ptr
            after = current.next;
            // make current ptr point to node before it
            current.next = before;
            // move before ptr
            before = current;
            // move current ptr
            current = after;
        }

        // now we wedge 2nd reversed half inbetween 1st half
        ListNode start = head;
        /*
         * at last before will be pointing to last element in whole list i.e.
         * starting point of reversed 2nd half
         */
        ListNode secStart = before;
        ListNode temp1 = null;
        ListNode temp2 = null;

        /* we only need to go till half */
        while (start != slow.next && secStart != null) {
            // Modifying a node (ptr.val or ptr.next) affects all references to it,
            // so temp sees the same changes since it points to the same object.
            // Reassigning ptr = new ListNode(...) only moves ptr to a new object;
            // temp still points to the old node, so temp.val/temp.next remain unchanged.
            // This is why we save start.next and secStart.next into temp1/temp2 first:
            // they preserve the original links before we overwrite them.
            temp1 = start.next;
            temp2 = secStart.next;
            // point node from 1st half to node from 2nd half
            start.next = secStart;
            // point node from 2nd half to node from 1st half
            secStart.next = temp1;
            // move both ptr
            start = temp1;
            secStart = temp2;
        }
    }
}
