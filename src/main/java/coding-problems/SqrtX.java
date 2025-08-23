class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;

        int left = 1, right = x, closestAns = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long midSq = (long) mid * mid;
            if(midSq == x) return (int) mid;
            else if(midSq < x) {
                left = (int) mid + 1;
                closestAns = mid;
            }
            else right = (int) mid - 1;
        }   

        return closestAns;     
    }
}