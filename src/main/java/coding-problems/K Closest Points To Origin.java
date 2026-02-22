class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /*
         * brute force approach : we just need to iterate through the arr and for each
         * point we need to calc its distance from origin and store it in an arr and
         * then
         * sort that arr and output k points from it
         */
        /*
         * or we can skip the arr and sorting by using heap and also no sqrt needed
         * since sqrt is always increasing i.e. so inequalities wont change if we do
         * sqrt
         * on both sides
         */

        /*
         * pq will treat whole int[] as 1 single obj but here this dont matter cause
         * we can pop to use each coordinates
         */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (p1, p2) -> Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]), (p1[0] * p1[0] + p1[1] * p1[1])));

        // main code
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            maxHeap.offer(p);

            /* we are using maxHeap so farthest pt will be on top so we can poll it */
            while (maxHeap.size() > k)
                maxHeap.poll();
        }

        // making 2d arr, will iterate through heap in order to avoid poll() on empty
        // heap
        int[][] ans = new int[k][2];
        int i = 0;
        while (maxHeap.isEmpty() == false) {
            ans[i] = maxHeap.poll();
            i++;
        }
        return ans;
    }
}
