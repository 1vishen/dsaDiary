class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
         * we will use a algo similar to 2sum hashmap based lookup where we store prefix
         * sum at index and its frequencies, so at any index j we will know, prefix[j] -
         * k = prefix[i] and freq of prefix[i] will tell us number of subarrays possible
         * at prefix[j]
         */

        Map<Integer, Integer> prefix = new HashMap<>();
        int count = 0;

        // the formaul is sum(i) - k = some earlier prefix, but at index 0 we dont have
        // any so if we find any subarray of size 1 at index 0 which equals k we need to
        // track that as well, for that we need to add sum = 0 and freq = 1 in map */
        prefix.put(0, 1);

        // calc prefix sum and freq
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // checking is any prefix sum exists
            sum += nums[i];
            if (prefix.containsKey(sum - k)) {
                count += prefix.get(sum - k);
            }

            // putting prefix sums in map
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
