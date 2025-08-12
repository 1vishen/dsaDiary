class Solution {
    public boolean isPowerOfFour(int n) {
        //base case
        if(n == 1) return true;

        if(n % 4 != 0 || n <= 0) return false;

        return isPowerOfFour(n / 4);
    }
}