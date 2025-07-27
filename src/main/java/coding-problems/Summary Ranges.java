class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        int leftRange = 0, i = 1;
        for(; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1) {
                continue;
            }
            else {
                if(leftRange == i - 1) {
                    result.add(String.valueOf(nums[leftRange]));
                }
                else {
                    result.add(String.valueOf(nums[leftRange]) + "->" + String.valueOf(nums[i - 1]));
                }
                leftRange = i;
            }
        }

        if(leftRange == nums.length - 1) {
            result.add(String.valueOf(nums[leftRange]));
        }
        else {
            result.add(String.valueOf(nums[leftRange]) + "->" + String.valueOf(nums[nums.length - 1]));
        }

        return result;
    }
}