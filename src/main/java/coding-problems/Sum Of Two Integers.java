class Solution {
    public int getSum(int a, int b) {
        /*
         * since Java integers are always stored in two’s complement, +ve num
         * look same but -ve look different, so making arr of binary representation
         * of nums then adding it also might go against of not using + - at all
         */

        /*
         * XOR (^): This is "Addition without Carry." AND (&) : This finds
         * the Carry. SHIFT (<<) : Since a carry moves to the next position,
         * we shift it
         */

        /*
         * Bitwise operators manipulate the 32-bit binary patterns of integers
         * simultaneously in a single CPU cycle, not one bit at a time. A loop is
         * needed because carries can cause new collisions in their new positions.
         * This chain reaction continues until no more carries are generated
         * (carry == 0).
         */

        int carry = Integer.MAX_VALUE;
        while (carry != 0) {
            carry = a & b;
            a = a ^ b;
            /*
             * After a ^ b we dont need original b, so b becomes shifted
             * carry. This process repeats until no more carries are generated.
             */
            b = carry << 1;
        }
        return a;
    }
}
