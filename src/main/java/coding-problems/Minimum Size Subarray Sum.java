class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /* - Expand -> check sum -> contract if valid -> update minLen -> repeat.
        Expanding until sum >= target. stop contracting when sum < target */

        int leftP = 0, rightP = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (rightP < nums.length) {
            sum += nums[rightP];
            rightP++;

            /* outer loop expands the window; inner loop contracts once the window is valid.
            as soon as the window is “valid” (sum >= target), the inner loop contracts from
            the left, It keeps shrinking until the window is no longer valid. */
            while (sum >= target) {
                // rightP++ after sum, so rightP is exclusive
                minLen = Math.min(minLen, (rightP - leftP));
                sum -= nums[leftP];
                leftP++;
            }
        }
        // if target bigger than all elements sum, then minLen stays max integer value
        return (minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
