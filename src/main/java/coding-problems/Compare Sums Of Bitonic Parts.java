class Solution {
    public int compareBitonicSums(int[] nums) {
        /*
         * i dont need to re-arrange elements or sort or anything so i will find peak in
         * 1st
         * iteration and then left/right sum in 2nd
         */

        // finding peak
        int peakInd = 0, peak = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > peak) {
                peakInd = i;
                peak = nums[i];
            }
        }

        // calc sum left and right of peak
        long leftSum = 0;
        long currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            /*
             * what i'll do is i will cal a running sum and stop when we reach peak and save
             * sum
             * till now to leftSum so finally currSum will have right sum only at end of
             * loop
             */
            if (i < peakInd) {
                currSum += nums[i];
            } else if (i == peakInd) {
                currSum += nums[i];
                leftSum = currSum;
                // currSum = nums[i] because peak belong to both sum
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
        }

        if (leftSum > currSum)
            return 0;
        else if (leftSum < currSum)
            return 1;
        else
            return -1;
    }
}
