class MedianFinder {

    /*
     * we will use 2 heaps : left contains 1st to middle right contains middle+1 to
     * last then that mean in edd both equal and in odd left has +1.
     */
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        // left should be max heap so that middle element floats to top
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // similarly, right should be min heap
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        /*
         * inserting, since heap only sort top(root) element we need to
         * take care that left-right split is correct
         */
        if (left.isEmpty() == true || num <= left.peek())
            left.offer(num);
        else
            right.offer(num);

        /*
         * balancing left and right, since we compare before inserting we only need
         * 1 swaps cause both can be at most +2 bigger than other
         */
        if (left.size() > right.size() + 1)
            right.offer(left.poll());
        if (right.size() > left.size())
            left.offer(right.poll());
    }

    public double findMedian() {
        // when odd, we have middle eleemnt in left
        double result = 0;
        if ((left.size() + right.size()) % 2 == 1) {
            result = left.peek();
        } else {
            /*
             * left+(right-left)/2 for safety, if number close to Integer.MAX/MIN_VALUE
             * it wont error out
             */
            result = (double) (left.peek() + right.peek()) / 2;
        }

        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
