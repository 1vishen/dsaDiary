class Solution {
    public int reverseBits(int n) {
        /*
         * << : Left shift — drops leftmost bit, adds 0 on the right;
         * decimal = multiply by 2.
         * >> : Arithmetic right shift — drops rightmost bit, adds sign bit on the left;
         * decimal = divide by 2 (preserve sign).
         * >>> : Logical right shift — drops rightmost bit, always adds 0 on the left;
         * decimal = divide by 2 treating int as unsigned.
         * <<< : (Not valid in Java) — only <<, >>, >>> exist.
         * not needed — would be identical to <<, so Java doesn’t define it.
         */

        /*
         * Bitwise AND (&) : works on bits (1 if both bits are 1)
         * → Used to extract last bit (n & 1 checks odd/even)
         * Logical AND (&&) : works on booleans (true if both conditions are true)
         * → Used in conditional checks (if both must be true)
         * 
         * Bitwise OR (|) : works on bits (1 if either bit is 1)
         * → Used to set specific bits (n | 1 forces last bit to 1)
         * Logical OR (||) : works on booleans (true if at least one condition is true)
         * → Used when at least one condition should pass
         * 
         * Bitwise XOR (^) : works on bits (1 if bits differ)
         * → Used to toggle bits (n ^ 1 flips last bit)
         * Logical XOR : no direct operator, but (a ^ b) works for booleans
         * → Used when exactly one condition must be true
         * 
         * Bitwise NOT (~) : flips every bit (0→1, 1→0)
         * → Used to invert all bits (two’s complement operations)
         * Logical NOT (!) : inverts a boolean (true→false, false→true)
         * → Used to negate conditions in logic
         */

        int[] binary = new int[32];
        int i = 0;
        while (n > 0) {
            int bit = n & 1;
            // extracting last bit ans storing it at 1st place to auto reverse it
            binary[i] = bit;
            i++;
            /*
             * In C++ we use unsigned int + >>, but Java has only signed int,
             * so we need >>> to shift right with zero-fill instead of sign extension.
             */
            n = n >>> 1;
        }

        int num = 0;
        for (int bit : binary) {
            // shift left, then bitwise OR to add a bit
            num = (num << 1) | bit;
        }
        return num;
    }
}
