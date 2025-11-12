class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
        - Using a Set violates the O(1) space constraint, even though it simplifies lookup.
        - The smallest missing positive integer must be in the range [1, n+1] where n = array
         length. This is because only n slots exist to hold values from 1 to n. If all are 
         present, answer is n+1. We can ignore negative numbers, zeros, and numbers > n since
          they can't occupy valid positions. Sorting the array is not allowed due to O(n log 
          n) time; instead, we simulate placement using in-place swaps.
        */

        for (int i = 0; i < nums.length; i++) {
            /*
            - We place each number x (1 ≤ x ≤ n) at index x - 1 if it's not already there.
            - After rearrangement, the first index i where nums[i] != i + 1 gives the missing
             number.
            - Swapping is done in a while loop to ensure the current index holds a valid value
             before moving on. This is necessary because the swapped-in value might also need
              to be placed
             correctly.
            - Without the while loop, we risk skipping values that should be placed 
            immediately.
            - Each number is moved at most once, so total time remains O(n).
            - The algorithm is not full sorting—just targeted placement of valid values.
            */
            // nums[i] != nums[nums[i] - 1] to avoid duplicates causing infinity loop
            while (nums[i] > 0 && nums[i] <= nums.length
                    && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                // element to be moved from correct spot
                int temp = nums[correctIndex];
                // moving 'element to be placed' at 'correct spot'
                nums[correctIndex] = nums[i];
                /* element that moved from 'correct spot' to current spot, may not be final
                 spot for it*/
                nums[i] = temp;
                /* after this new element will be at nums[i] which may/may not be the correct
                 element but algo will work till nums[i] != i + 1 so finally nums[i] will be 
                 the correct one or one we don't care about, <= 0*/
            }

        }

        // finding the smallest +ve num not in arr
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        /* if all the elements are at their right index then we have +ve integers from 1 to
         nums.length in the arr so next smallest +ve int will be nums.length + 1 */
        return nums.length + 1;
    }
}
