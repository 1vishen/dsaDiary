class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for(int num : nums1) {
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < nums2.length; i++) {
            if(nums1Map.containsKey(nums2[i]) && nums1Map.get(nums2[i]) != 0) {
                result.add(nums2[i]);
                nums1Map.put(nums2[i], nums1Map.get(nums2[i]) - 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}