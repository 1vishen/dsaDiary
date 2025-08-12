class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        if(n == 1) return true; // 2^0 = 1
        int rem = 0;
        while(n > 0) {
            rem = n % 2;
            if(rem != 0 && n != 1) return false;
            n = n / 2;
        }

        return true;
    }
}