class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // data str = hashmap, arrays, algo/pattern = hashing

        /* I can write a separate method for reverse and dropping leading zeros then for each
            index i, I store then current index and required reversed number in map,
            then if at any i requirements are met I calculate dist by "current i - stored i"
            and compare result to last stored minAbsDist */

        Map<Integer, Integer> recordMap = new HashMap<>();
        int minAbsDist = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            if(recordMap.containsKey(nums[i])) {
                int currMinAbsDist = i - recordMap.get(nums[i]);
                minAbsDist = Math.min(minAbsDist, currMinAbsDist);
            }

            /* put() willl overwrite the existing value if key already exists which is what 
            we want, if 2 index have same value we want most recent index */
            recordMap.put(rev, i);   
        }
        return minAbsDist == Integer.MAX_VALUE ? -1 : minAbsDist;
    }

    public int reverse(int n) {
        int revN = 0;
        // this handles trailing zeros by itself, cause digit = 0 when 120 % 10
        while(n > 0) {
            int digit = n % 10;
            revN = revN * 10 + digit;
            n = n / 10;
        }
        return revN;
    }
}

