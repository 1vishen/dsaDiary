class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
         * we sort by end interval that way we can maximize the size and minimize the
         * no of intervals to take out
         */

        // sorting
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // main logic
        int removes = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] pair = intervals[i];
            if (pair[0] < prevEnd)
                removes++;
            else
                prevEnd = intervals[i][1];
        }
        return removes;
    }
}
