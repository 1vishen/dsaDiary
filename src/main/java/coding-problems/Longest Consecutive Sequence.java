class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        // inserting all elements into array for easy lookup
        Set<Integer> hashset1 = new HashSet<>();
        for(int num : nums) {
            hashset1.add(num);
        }
        int maxCounter = 0;

        for (int n : hashset1) {
            if (hashset1.contains(n - 1)) {
                /* we only start counting when n - 1 is not in the set, meaning n is the
                 start of a sequence */
                continue;
            } 
            else {
                int counter = 0;
                int currentN = n;
                while (hashset1.contains(currentN)) {
                    currentN += 1;
                    counter++;
                }
                // to keep track of maximum seq
                maxCounter = Math.max(counter, maxCounter);
            }
        }
        return maxCounter;
    }
}