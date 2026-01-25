class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
         * so we need max for each window and then combine all maxes into ans arr, I can
         * use max heap to do that
         */

        List<Integer> ans = new ArrayList<>();

        /*
         * making a priority queue that stores entry set values of a map in descending
         * order of values
         */
        PriorityQueue<Map.Entry<Integer, Integer>> windowMax = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // adding first k elements, then we will add/remove elements to heap as we move
        // our window, this way we will have less time complexity */
        for (int i = 0; i < k; i++) {
            windowMax.offer(Map.entry(i, nums[i]));
        }
        ans.add(windowMax.peek().getValue());

        // creating sliding window
        int left = 0, right = k - 1;
        while (right < nums.length - 1) {
            /*
             * now we move and add elements from right, remove from left and add max to ans
             * arr
             */
            right++;
            windowMax.offer(Map.entry(right, nums[right]));
            left++;

            while (windowMax.peek().getKey() < left) {
                windowMax.poll();
            }
            ans.add(windowMax.peek().getValue());

        }
        return ans.stream().mapToInt(x -> x.intValue()).toArray();
    }
}
