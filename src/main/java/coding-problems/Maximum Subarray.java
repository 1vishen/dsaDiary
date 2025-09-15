class Solution {
    public int maxSubArray(int[] nums) {
        /* kadane algo: only resets when the running sum becomes negative, cause:
        if at any point sum becomes negative then no point keeping it because 0 is obviously 
        greater than negative, so just make your sum 0. */

        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); /* At each step, choose the
            better option: either start a new subarray at nums[i], or extend the current one. 
            This handles negative sums (when full array is -ve) gracefully without resetting
            currentSum to zero explicitly (like when no fully -ve arrays are there). */
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}