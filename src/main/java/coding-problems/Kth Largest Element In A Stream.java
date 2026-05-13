class KthLargest {
    /*
     * the problem wants a filter bucket where for eg above 70 cutoff and 3 students
     * only so 99,88,77 and if next one comes and its
     * 78 we remove 77 and add 78 and then return 78 as the current cutoff, keep
     * adding from nums and remove whenever heap size > k so
     * final heap size = k
     */

    // we need a min heap, and min element in it will be the gatekeeper
    PriorityQueue<Integer> scores = new PriorityQueue<>();
    // to keep k persistently
    int k2;

    public KthLargest(int k, int[] nums) {
        k2 = k;

        for (int i = 0; i < nums.length; i++) {
            if (this.scores.size() < k)
                this.scores.offer(nums[i]);
            else if (this.scores.size() == k && nums[i] > this.scores.peek()) {
                this.scores.poll();
                this.scores.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (this.scores.size() < k2)
            this.scores.offer(val);
        else if (this.scores.size() == k2 && val > this.scores.peek()) {
            this.scores.poll();
            this.scores.offer(val);
        }

        return scores.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
