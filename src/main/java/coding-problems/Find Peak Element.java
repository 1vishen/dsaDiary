class Solution {
    public int findPeakElement(int[] nums) {
        /* we know any element is considered peak when compared to outside array's size
            so we will use that, and since we need O(log n) binary search is needed
            and in binary search we dont need sorted array we just need a consdition
            that can reliably discard one half of array. if num at mid is greater than 
            its right then we have a falling slope and a peak must be at mid or left of
            mid, and vice versa when its lesser */

        // above logic works for local peaks not max peak in all array

        int left = 0, right = nums.length - 1;

        /* while (left < right) ensures that the loop runs only while there are at 
            least 2 distinct elements in the current range. */
        while (left < right) {
            int mid = left + (right - left) / 2;

            // no = cause we need strictly greater than
            if (nums[mid] > nums[mid + 1]) {
                // not -1 cause in this case mid can also be a peak
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}