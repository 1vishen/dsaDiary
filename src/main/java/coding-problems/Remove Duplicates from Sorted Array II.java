class Solution {
    public int removeDuplicates(int[] nums) {
        // we'll have 2 pointers: read and write
        // since nums[0] will always be there, we need to start writeP from 1
        int writeP = 1;
        // count from 1 cause when starting we've aleeady seen the number we are currently on
        int count = 1;

        /* we need to start readP from 1 cause nums[0] will always be there
            and we need to compare current element to prev element */
        for (int readP = 1; readP < nums.length; readP++) {
            if (nums[readP] == nums[readP - 1]) {
                count++;
            } 
            else count = 1;
            // evaluating count
            if (count <= 2) {
                nums[writeP++] = nums[readP];
            }
        }
        /* writeP will be next to the last element, so we don't need to do writeP + 1 
            even though writeP is representing an index */
        return writeP;
    }
}