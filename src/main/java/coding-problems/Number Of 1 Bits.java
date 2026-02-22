class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // bit can be 1 or 0, & only gives 1 when both are 1
            if ((n & 1) == 1)
                count++;
            // drop the last bit
            n = n >> 1;
        }
        return count;
    }
}
