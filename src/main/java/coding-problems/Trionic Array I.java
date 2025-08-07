class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length < 3) return false;
        int i = 0, n = nums.length;

        //increasing only
        while(i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if(i == 0 || i == n - 1) return false;

        //decreasing only
        int p = i;
        while(i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if(i == p || i == n - 1) return false;

        //increasing only
        int q = i;
        while(i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if(i == q) return false;

        //if everything is trionic as we want i should have reached at last index;
        return i == n - 1;
    }
}