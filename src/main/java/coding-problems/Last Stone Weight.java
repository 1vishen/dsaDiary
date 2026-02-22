class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
         * since we need 2 heaviest stones each time not just once, we can use max heap
         * to
         * achieve this
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        /*
         * storing all stones inside maxHeap, since - problem only cares about the last
         * stone’s weight, we don’t need the index at all
         */
        for (int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }

        //
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 == stone2)
                continue;
            // cause of heap stone1 will always be >= stone2
            else if (stone1 > stone2) {
                stone1 = stone1 - stone2;
                maxHeap.offer(stone1);
            }

        }
        /*
         * we poll() 2 stones each time, so if heap has exactly 2 it will have none, for
         * that case we need to return 0
         */
        return maxHeap.peek() == null ? 0 : maxHeap.peek();
    }
}
