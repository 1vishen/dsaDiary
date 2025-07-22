class Solution {
    public int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length; i+=2){
        //     if(nums[i] != nums[i + 1]) return nums[i];
        // }
        // return -1;
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }
        return result;
    }
}