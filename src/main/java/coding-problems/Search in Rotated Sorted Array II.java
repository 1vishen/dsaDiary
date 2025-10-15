class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return true;
            /* if nums[left] == nums[mid] and nums[mid] == nums[right] we wont know
                which half is sorted so we need to skip them */
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
                continue;
            }
            // checking if left half is sorted, so that we can apply binary search
            if (nums[left] <= nums[mid]) {
                // if target exists between mid and left 
                if (target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }
            // if right laft is sorted, same logic as left one
            else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}