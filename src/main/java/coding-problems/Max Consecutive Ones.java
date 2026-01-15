class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /* i'll do jellyfish like sliding window, where i expand it till there are ones then if not 1 then contract till 0 then move till i see 1 again and start expanding again */

        int left = 0, right = 0;
        int maxConsecutive = 0;

        for(; right < nums.length; right++) {
            int e = nums[right];

            // if not 1 then collapse window and more left to a posn after 0 cause otherwise we will accidently include 0 in consecutive ones if we just do left = right
            if(e != 1) {
                // shrinking the window to 0
                left = right + 1;
            }

            if(e == 1) {
                // we need max consecutive so we always compare with prev max before blindly accepting
                maxConsecutive = Math.max(maxConsecutive, right - left + 1);
            }
        }

        return maxConsecutive;

    }
}
