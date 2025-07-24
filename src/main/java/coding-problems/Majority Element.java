class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > maxValue){
                 maxValue = entry.getValue();
                 maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}