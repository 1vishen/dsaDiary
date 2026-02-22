class Solution {
    public int jump(int[] nums) {
        // for each index we choose num that makes our reach max

        int jumps = 0;
        int currentWindowEnd = 0;
        int farthest = 0;

        /*
         * we only need to jump till 1 index before last, at last index we dont need
         * to jump
         */
        for (int i = 0; i < nums.length - 1; i++) {
            // calc farthest we can reach currently
            farthest = Math.max(farthest, i + nums[i]);

            // check if window ended, if yes then increase jumps and shrink the window
            if (i == currentWindowEnd) {
                jumps++;
                /*
                 * we update current window as farthest we can reach with elements
                 * from current window
                 */
                currentWindowEnd = farthest;
            }
        }
        return jumps;
    }
}
