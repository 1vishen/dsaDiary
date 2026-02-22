class Solution {
    public int maxTurbulenceSize(int[] arr) {
        /*
         * we can use sliding window with a greedy approach, we need to track last
         * used inequality and flip it
         */

        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return 1;

        int len = 0;
        int left = 0, right = 0;
        char prev = ' ', curr = ' ';
        while (right < arr.length - 1) {
            /*
             * right++ only happens once per iteration because it’s inside the same
             * one if/else chain
             */

            // get the current
            if (arr[right] > arr[right + 1])
                curr = '>';
            else if (arr[right] < arr[right + 1])
                curr = '<';
            else
                curr = '=';

            if (curr == '=') {
                /*
                 * here we shouldnt start from curr element fro our subarr cause
                 * next is equal to curr so we should start from next actually
                 */
                len = Math.max(len, right - left + 1);
                right++;
                left = right;
            } else if (curr == prev) {
                len = Math.max(len, right - left + 1);
                // we update left before moving right to start new subarr at curr ele
                left = right;
                right++;
            } else {
                prev = curr;
                /*
                 * we ++ right before len calc cause if turbulence continues then both
                 * rigth and right + 1 are incl in subarr
                 */
                right++;
                // we always record length to have accurate length always
                len = Math.max(len, right - left + 1);
            }
        }

        /*
         * since right - left + 1 already counts incl both ends (left, right) last
         * element is already included
         */
        return len;
    }
}
