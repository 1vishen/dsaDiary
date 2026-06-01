/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /*
         * we can make an equivalent arraylist but the thing is how to handle
         * dups if we get dups how to know its next element or a prev one, I guess
         * we can keep track of next for each node 'next' should be different so we
         * can use a set of set.contains() == true then we will know that its
         * cyclic because from my understanding next var is storing object reference
         * not its value
         */

        Set<ListNode> set1 = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (set1.contains(current))
                return true;
            else
                set1.add(current);

            // advance the nodes
            current = current.next;
        }

        return false;
    }
}
