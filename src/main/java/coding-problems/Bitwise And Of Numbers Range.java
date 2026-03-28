class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        /*
         * The AND of a CONTINOUS range [left, right] is the common prefix of left and
         * right in binary. The moment you hit a position where left and right differ,
         * all
         * lower bits (to the right of that position) must be set to 0 in the final
         * answer
         */

        int count = 0;
        while (left != right) {
            left = left >> 1; // right shift is / 2
            right = right >> 1; // right shift is / 2
            count++;
        }

        while (count > 0) {
            left = left << 1; // left shift is * 2
            // right = right << 1; is not needed since in prev while both became equal
            count--;
        }
        return left;
    }
}
