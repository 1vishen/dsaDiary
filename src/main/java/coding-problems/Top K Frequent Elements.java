class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /* A heap doesn’t fully sort all elements—it only guarantees the root is the min or max.
            its implemented using PriorityQueue in java */
        Map<Integer, Integer> map1 = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int e = nums[i];

            // make a freq map
            map1.put(e, map1.getOrDefault(e, 0) + 1);
        }

        /* add k elements to heap, so that we have at least k elements otherwise we will keep putting/removing only 1 element in heap */
        /* we need a heap of key value pairs */
        /*
        class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b)
            {
                return a.getValue() - b.getValue();  // sort by frequency
            }
        }
        we can use lambda of this
        */

        PriorityQueue<Map.Entry<Integer, Integer>> heap1 = new PriorityQueue<>(
                (a, b) ->
                        Integer.compare(a.getValue(), b.getValue())
        );

        for(Map.Entry<Integer, Integer> m : map1.entrySet()) {
            /* we dont need to check values of keys, our comparator will auto sort and heap
                will push smallest to head */
            heap1.offer(m);

            // this way eventually we will be left with top k elements only
            if(heap1.size() > k) {
                heap1.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < result.length; i++) {
            result[i] = heap1.poll().getKey();
        }
        return result;
    }
}
