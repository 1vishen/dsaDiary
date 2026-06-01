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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        /*
         * since numbers are rev we can start from 1st node, we need to
         * know which LL is shorter because we will add result in larger one
         */

        // determine shorter LL
        boolean l1short = false, l2short = false;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode lastNode = null;

        while (curr1 != null && curr2 != null) {
            /* we make count 0 for whichever LL we reach end first */
            if (curr1.next == null) {
                l1short = true;
                break;
            }
            if (curr2.next == null) {
                l2short = true;
                break;
            }

            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        // assuming curr1 is shorter and curr2 is longer LL
        if (l1short == true) {
            curr1 = l1;
            curr2 = l2;
        } else {
            curr1 = l2;
            curr2 = l1;
        }

        // actual addition
        int carry = 0;
        int v1 = 0, v2 = 0;
        while (curr1 != null) {
            v1 = curr1.val;
            v2 = curr2.val;

            int sum = v1 + v2 + carry;
            // carry is used make it 0
            carry = 0;
            if (sum > 9) {
                // get unit place digit, unit place we keep
                curr2.val = sum % 10;
                sum = sum / 10;
                // get 10s place, 10s place we carry;
                carry = sum % 10;
            } else {
                curr2.val = sum;
            }

            if (curr2.next == null)
                lastNode = curr2;

            // move both ptr
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // finally we need to make carry 0 in order to finish addition
        while (curr2 != null && carry != 0) {
            /*
             * when curr1 becomes null that means it is past the last node
             * of smaller LL and curr2 is at the node which is 1 ahead of last
             * node of smaller LL
             */
            int sum = curr2.val + carry;
            carry = 0;
            if (sum > 9) {
                // get unit place
                curr2.val = sum % 10;
                sum = sum / 10;
                carry = sum % 10;
            } else {
                curr2.val = sum;
            }

            if (curr2.next == null)
                lastNode = curr2;

            // move ptr
            curr2 = curr2.next;
        }
        /*
         * if we reach end with carry not 0 that means we need 1 more
         * node to store value of carry than size of larger LL
         */
        if (carry != 0)
            lastNode.next = new ListNode(carry);

        // return the larger LL
        return l1short == true ? l2 : l1;
    }
}
