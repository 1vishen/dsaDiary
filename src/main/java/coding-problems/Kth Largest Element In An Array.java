class Solution {
    public int findKthLargest(int[] nums, int k) {
        // i can make a max heap and pop k - 1 times
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // adding to heap
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        // popping from heap
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
