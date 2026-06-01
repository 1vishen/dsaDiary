/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // get linkedlist length
        int n = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }

        /* make a LL first */
        int count = 1;
        Node headNew = new Node(0);
        Node curr2 = headNew;
        while (count < n) {
            curr2.next = new Node(0);
            curr2 = curr2.next;
            count++;
        }

        // populating the new LL
        count = 0;
        // original list
        Node curr3 = head;
        // new list
        Node curr4 = headNew;
        // its good to guard against NPE even if both LL are equal size
        while (count < n && curr3 != null && curr4 != null) {
            curr4.val = curr3.val;
            curr3 = curr3.next;
            curr4 = curr4.next;
            count++;
        }

        /*
         * now for random ptr : its like this inside map [(node1 ref -> node1new
         * ref)(node2 ref -> node2new ref)…. etc] so if in original we see node1_ref in
         * original we put node1new_ref in copy
         */

        Map<Node, Node> refMap = new HashMap<>();
        count = 0;
        curr3 = head;
        curr4 = headNew;
        while (count < n && curr3 != null && curr4 != null) {
            refMap.put(curr3, curr4);
            curr3 = curr3.next;
            curr4 = curr4.next;
            count++;
        }
        // now after this we build random ptr connections in new copy
        count = 0;
        curr3 = head;
        curr4 = headNew;
        while (count < n) {
            if (curr3.random != null) {
                curr4.random = refMap.get(curr3.random);
            } else
                curr4.random = null;

            curr3 = curr3.next;
            curr4 = curr4.next;
            count++;
        }

        return headNew;
    }
}
