class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        /*
         * since i've to rescan the arr each time till no adj are equal
         * i can use a stack to pop compare and push again
         */

        ArrayDeque<Long> stack1 = new ArrayDeque<>();

        for (int num : nums) {
            long val = num;

            while (stack1.isEmpty() == false && stack1.peekLast() == val) {
                // pop and add to val
                val = val + stack1.removeLast();
            }
            stack1.addLast(val);
        }
        return new ArrayList<>(stack1);
    }
}
