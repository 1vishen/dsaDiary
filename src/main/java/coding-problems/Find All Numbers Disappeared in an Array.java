class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int[] freqMapArray = new int[nums.length + 1];

        for(int num : nums) {
            freqMapArray[num]++;
        }

        for(int i = 1; i < freqMapArray.length; i++) {
            if(freqMapArray[i] == 0) result.add(i);
        }

        return result;
    }
}