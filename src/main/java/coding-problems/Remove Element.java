class Solution {
    public int removeElement(int[] nums, int val) {
        int atLast = nums.length - 1, i = 0;
        while (i <= atLast) {
            if (nums[i] == val) {
                nums[i] = nums[atLast];
                nums[atLast] = val;
                atLast--;
            } else {
                i++;
            }
        }
        return atLast + 1;
    }
}