class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        /* not <= cause when left == right loop will break and we will have our ans as:
            nums[left] will be same as nums[right] == ans*/
        while(left < right) {
            int mid = left + (right - left) / 2;

            // nums[mid] > nums[right], that means min is on right side, else on left
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if(nums[mid] <= nums[right]) {
                /* cant do right = mid - 1 cause right now mid might can still be the min
                    so we cant skip it yet, we dont know as we are not comparing mid 
                    anywhere */
                right = mid;
            }
        }
        return nums[left];
    }
}