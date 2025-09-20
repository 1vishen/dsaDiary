class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];

        // sorting
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        int[] current = intervals[0];
        for(int i = 1; i < intervals.length; i++) {

            if(current[1] >= intervals[i][0]) {
                // Merge overlapping intervals
                current[1] = Math.max(current[1], intervals[i][1]);
            }
            else {
                // No overlap → add current interval
                ans.add(current);
                current = intervals[i]; /* cause if was skipped so intervals[i] is 
                                            already ahead of current always */
            }
        }

        // adding last element in intervals
        ans.add(current);

        // converting to int[][]
        int[][] finalAns = new int[ans.size()][2];
        int i = 0;
        for(int[] subarray : ans) {
            finalAns[i++] = subarray;
        }
        return finalAns;
    }
}