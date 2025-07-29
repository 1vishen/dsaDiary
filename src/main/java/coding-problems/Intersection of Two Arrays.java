class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for(int num : nums1) {
            nums1Set.add(num);
        }

        Set<Integer> resultSet = new HashSet<>();

        for(int i = 0; i < nums2.length; i++) {
            if(nums1Set.contains(nums2[i])) resultSet.add(nums2[i]);
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for(int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }
}