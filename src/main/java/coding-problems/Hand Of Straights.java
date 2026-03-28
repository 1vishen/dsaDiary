class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        /*
         * I will make freq arr of hand arr then I will run through the freq arr
         * starting from first non zero freq then when grp size reached I start again
         * from
         * the first non zero freq, so for eg. if I have 2 with freq 2 then for 2nd time
         * we will start with 2 again, but since 0 <= hand[i] <= 10^9 we cant use freq
         * arr
         * we need to use map that support sorting i.e. treemap
         */

        // sort by keys asc by default
        TreeMap<Integer, Integer> freq1 = new TreeMap<>();

        // making freq map
        for (int n : hand) {
            freq1.put(n, freq1.getOrDefault(n, 0) + 1);
        }

        // checking consecutive groups
        int size = freq1.size();
        while (size > 0) {
            /*
             * firstKey() → returns the lowest key currently in the map,
             * lastKey() → returns the highest key
             */
            int start = freq1.firstKey();

            for (int i = 0; i < groupSize; i++) {
                // for first since i = 0 curr = start
                int curr = start + i;

                if (freq1.get(curr) == null)
                    return false;
                else {
                    // decrease freq by 1
                    freq1.put(curr, freq1.get(curr) - 1);
                }

                // remove if freq becomes 0
                if (freq1.get(curr) == 0)
                    freq1.remove(curr);
            }
            // update size var so that it can decrease as well
            size = freq1.size();
        }
        return true;
    }

}
