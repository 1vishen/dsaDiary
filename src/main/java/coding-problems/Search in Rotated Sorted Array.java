class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;

            /* left half is sorted but target can/cant be here
               right half is sorted but target can/cant be here
            */
            if(nums[left] <= nums[mid]) {
                //left half is sorted
                if(target >= nums[left] && target < nums[mid]) {
                    //target is in left half
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                //right half is sorted
                if(target <= nums[right] && target > nums[mid]) {
                    //target is in right half
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}