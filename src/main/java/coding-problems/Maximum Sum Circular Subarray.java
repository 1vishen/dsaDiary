class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /*
         * we can use kadane algo, but we need to do it twice to 1st find max subarr
         * then min subarr and we can get max circular subarr by subtracting min from
         * total sum
         */

        // calc total sum
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        /*
         * calc maxSubArrSum, starting both sum as 1st element to handle both +ve &
         * -ve numbers
         */
        int maxSubArrSum = nums[0], currSum1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if current sum becomes -ve drop the subarr and start new from curr ele
            currSum1 = Math.max(nums[i], currSum1 + nums[i]);

            // calc max sum
            maxSubArrSum = Math.max(maxSubArrSum, currSum1);
        }

        // calc minSubArrSum
        int minSubArrSum = nums[0], currSum2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if current sum becomes +ve drop the subarr and start new from curr ele
            currSum2 = Math.min(nums[i], currSum2 + nums[i]);

            // calc min sum
            minSubArrSum = Math.min(minSubArrSum, currSum2);
        }

        /*
         * if maxSubArrSum is -ve then we have all -ve numbers then we can just return
         * maxSubArrSum only
         */
        if (maxSubArrSum < 0)
            return maxSubArrSum;
        else
            return Math.max(maxSubArrSum, totalSum - minSubArrSum);
    }
}
