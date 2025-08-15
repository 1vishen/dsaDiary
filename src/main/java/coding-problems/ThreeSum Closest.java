class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int length = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < length - 2; i++) {
            int j = i + 1, k = length - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - sum) < Math.abs(target - closest)) closest = sum;

                if(sum == target) return sum;
                else if(sum > target) k--;
                else if(sum < target) j++;                
            }
        }
        return closest;
    }
}