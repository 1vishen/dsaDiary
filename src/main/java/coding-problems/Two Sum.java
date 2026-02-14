class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map1.containsKey(complement)){
                return new int[] {i, map1.get(complement)};
            }
            map1.put(nums[i], i);
        }
        return new int[] {};
    }
}