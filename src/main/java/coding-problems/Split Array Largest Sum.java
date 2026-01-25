class Solution {
    public int splitArray(int[] nums, int k) {
        /*
         * since max nof of subarrays will be 1 element subarray and min nof of
         * subarrays will be whole array itself, so we are taking these 2 extremes as
         * boundaries and doing binary search to check if we can decrease the sum any
         * further without exceeding k subarrays
         */

        // finding max single element and whole arr sum
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            sum += nums[i];
        }

        // binary search b/w max and sum
        int left = max, right = sum;
        int minLargestSumOfAnySubArr = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int subArrCount = getSubArrCount(nums, mid);

            // check if num of subarr we get exceeds required i.e. k
            if (subArrCount <= k) {
                right = mid - 1;
                minLargestSumOfAnySubArr = mid;
            } else if (subArrCount > k)
                left = mid + 1;
        }
        return minLargestSumOfAnySubArr;

    }

    int getSubArrCount(int[] arr, int maxSum) {
        int count = 0;
        int runningSum = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            /*
             * if runningSum exceeds our maxsum on adding a new element we cut that subarr
             * as separate and begin new subarr with our current element as 1st element
             */
            if (runningSum > maxSum) {
                count++;
                runningSum = arr[i];
            }
        }
        // counting the last subarr
        if (runningSum != 0)
            count++;
        return count;
    }
}
