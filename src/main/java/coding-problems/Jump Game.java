class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        /* we will try to extend our reach, so at each index we check if that index
            helps us extend our reach more than current maxReach if yes then we make
            that our new maxReach */

        for (int i = 0; i < nums.length; i++) {
            if (i <= maxReach) { // need to check if current i is even reachable by maxReach
                maxReach = Math.max(maxReach, nums[i] + i); /* need to consider i cause we
                                                                need to check how far can we
                                                                 reach FROM i */
            }

            if (maxReach >= nums.length - 1)
                return true;
        }
        return false;
    }
}