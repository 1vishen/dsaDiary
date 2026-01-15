class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* i'll use prefix sum concept, i'll build 2 arr from left to right and from right to left each having prefix product */

        // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            // for calc suffix in same loop
            int j = nums.length - 1 - i;

            if(i == 0) prefix[i] = nums[i];
            else {
                prefix[i] = prefix[i - 1] * nums[i];
            }

            if(j == nums.length - 1) suffix[j] = nums[j];
            else {
                suffix[j] = suffix[j + 1] * nums[j];
            }
        }

        //now for constructing answer arr
        for(int i = 0; i < answer.length; i++) {
            // for 1st and last index we only need 1 of (prefix/suffix arr) cause other contains the current element
            if(i == 0) answer[i] = suffix[i + 1];
            else if(i == answer.length - 1) answer[i] = prefix[i - 1];
            else {
                answer[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return answer;
    }
}
