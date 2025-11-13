class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        int limit = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        for(int key : freqMap.keySet()) {
            if(freqMap.get(key) > limit) result.add(key);
        }
        return result;
    }
}