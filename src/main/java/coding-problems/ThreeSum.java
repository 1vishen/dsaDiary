class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tripletSet = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            /* once nums[i] > 0 no triplet will sum to 0 */
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            /*
             * we avoid i,left,right should not be equal to each other
             * by basung left and right on i
             */
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[left]);
                    triplets.add(nums[right]);

                    /* we avoid triplet duplicates same as we did for i */
                    tripletSet.add(triplets);
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return tripletSet;

    }
}