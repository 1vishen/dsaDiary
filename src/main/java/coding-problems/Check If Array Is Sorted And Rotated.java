class Solution {
    public boolean check(int[] nums) {
        /*
        In a sorted array, there is zero "descending" steps. When you rotate it once, you create exactly one point where the sequence "breaks" (the last element of the original sorted list becomes greater than the first element of the original list).
        */

        /* basically if its rotated once we will have 1 point where the sorting breaks */

        int breakCounter = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) breakCounter++;
        }

        /* we need to check this cause if arr was rotated after sorting then last element should be smaller than 1st, cause 1st element was in middle somewhere before rotation, this also includes rotation at k == 0 as well cause we are counting rotations at 0 posn as well */
        if(nums[nums.length - 1] > nums[0]) breakCounter++;

        /* breakCOunter == 0 for cases like [1] or [2,2,2] */
        return (breakCounter == 1 || breakCounter == 0) ? true : false;
    }
}
