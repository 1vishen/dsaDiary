class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length == 0) return new ArrayList<List<Integer>>();

        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1, right = nums.length - 1;

                while(left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    List<Integer> tempList = new ArrayList<>();

                    if(sum == target) {
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);

                        resultSet.add(tempList);
                        left++;
                        right--;
                    }
                    else if(sum > target) {
                        right--;
                    }
                    else{
                        left++;
                    }

                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}