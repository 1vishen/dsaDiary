class Solution {
    public int dominantIndices(int[] nums) {
        // brute forcing with avg(int[] arr) for each element will be O(n^2)

        /*
         * if i calc sum of whole arr then i can sub each element as i move through arr
         * to get sum of elements to right of element and / count of those elements
         */

        if (nums.length <= 1)
            return 0;

        // total sum
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // main logic
        int dominant = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum = sum - nums[i];
            int count = nums.length - 1 - i;

            // since div truncates decimals we can do mul
            if ((long) nums[i] * count > sum)
                dominant++;
        }
        return dominant;
    }
}
