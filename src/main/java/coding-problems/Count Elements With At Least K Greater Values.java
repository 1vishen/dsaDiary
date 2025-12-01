class Solution {
    public int countElements(int[] nums, int k) {
        // data str = arrays, algo/pattern = sorting, counting
        /* we will use sorting + counting, we need to know how many elements
            are greater than current element, but elements equal to current
            element dont count eg. [5,5,5] ans = 0 */

        Arrays.sort(nums);
        int totalQualified = 0;

        for(int i = 0; i < nums.length;) {
            int currEle = nums[i];
            int equalToCurrEle = i;

            while(equalToCurrEle < nums.length && nums[equalToCurrEle] == nums[i]) {
                equalToCurrEle++;
            }
            /* we can skip counting for duplicates of current element by skipping i to posn where
            equalToCurrEle lands finally, and all elements between i and equalToCurrEle will be 
            equal and all will be qualified */
            int blockSize = equalToCurrEle - i;
            int countGreater = nums.length - equalToCurrEle;
            if(countGreater >= k) totalQualified += blockSize;
            i = equalToCurrEle;
        }
        return totalQualified;
    }
}