class Solution {
    public long minEnd(int n, int x) {
        // how many increments we need
        long inc = n - 1;
        // start with x
        long ans = x;
        /*
         * start with mask 1 (binary 0001) to check the rightmost bit of ans.
         * In each loop iteration we shift left (bit <<= 1), so the mask moves across
         * ans:
         * 0001 → 0010 → 0100 → 1000, etc. This lets us test each bit position of ans in
         * turn to find the next free (0) slot.
         */
        long bit = 1;

        // slot bits of (n-1) into zero-bit positions of x
        while (inc > 0) {
            // if this bit in x is free (0)
            if ((ans & bit) == 0) {
                /*
                 * check lowest bit of (n-1); if it's 1, place it here. then inc >>= 1
                 * shifts right to peel off the next bit.
                 */
                if ((inc & 1) == 1) {
                    // set it here i.e. turn on this bit in ans if needed
                    /*
                     * bit is a mask that shifts left each loop (0010, 0100, 1000, …).
                     * ans & bit checks if that slot is free, and if inc’s lowest bit is 1
                     * then ans | bit turns on that position in ans
                     */
                    ans = ans | bit;
                }
                /*
                 * move to next bit of inc, i.e. shift inc right to process its next
                 * lowest bit
                 */
                inc = inc >> 1;
            }
            /*
             * move to next position in x, i.e. shift mask left so we check the next
             * bit slot in ans
             */
            bit = bit << 1;
        }
        return ans;
    }
}
