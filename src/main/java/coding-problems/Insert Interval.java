class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        // handling empty 2d array
        if(intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        // this i will keep track of current sub-array throughout 3 steps
        int i = 0;
        // step1: all sub-arrays before newInterval
        for(; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0])
                result.add(intervals[i]);
            else break;
        }

        // step2: handling insert and merging
        int[] tempNewInterval = newInterval;
        /* need to expand newInterval's left to lowest but only once so outside loop.
        since i is already at the place which broke step1 and by condition in 
        step 1 we know that newinterval's 0th element is always smaller than 1st
        element of where i currently is cause thats where we break step1 */
        if(i < intervals.length)
            tempNewInterval[0] = Math.min(intervals[i][0], tempNewInterval[0]);
        for(; i < intervals.length; i++) {
            // if overlap expand
            if(tempNewInterval[1] >= intervals[i][0]) {
                tempNewInterval[1] = Math.max(intervals[i][1], tempNewInterval[1]);
            }
            // if not then add
            else {
                break;
            }
        }
        // adding newInterval after merging
        result.add(tempNewInterval);

        // step3: all sub-arrays after newInterval
        for(; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }
}